import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;
import com.ds.input.processor.CommandExecutorFactory;
import com.ds.input.validator.CommandEnum;

import java.util.*;
import java.util.stream.Collectors;

public class CommandMachine {

	public static void main(String[] args) throws Exception{
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please Input commands");
		List<CommandEnum> commands = null;
		Map<String, LinkedList<String>> commandItems = null;

		while(myObj.hasNextLine()){
			String userInput = myObj.nextLine();
			if(userInput.length() < 80){
				String isValidCommand = CommandEnum.asList().stream().filter(x -> {
					return userInput.startsWith(x);
				}).findFirst().orElse(null);
				if(commands == null && commandItems == null){
					commands = new ArrayList<>();
					commandItems = new HashMap<>();
				}
				if(isValidCommand!=null){
					String[] userInputArr = removeEmptySpaces(userInput).split(" ");
					if(userInputArr.length >= 1) {
						CommandEnum commandEnum = contains(userInputArr[0]) ? CommandEnum.valueOf(userInputArr[0]): null;
						String commandKey = Arrays.stream(userInputArr).filter(x -> !contains(x)).findFirst().orElse(null);
						if(!commandItems.containsKey(commandKey)){
							commandItems.put(commandKey, Arrays.stream(userInputArr).filter(x -> !contains(x)).collect(Collectors.toCollection(LinkedList::new)));
						}
						if(commandEnum.isExecutable()){
							CommandRequest commandRequest = new CommandRequest();
							CommandProcessor processor = CommandExecutorFactory.getCommandProcessor(commandEnum.name());
							commandRequest.setCommandCode(commandEnum.name());
							commandRequest.setKeyIdentifier(commandKey);
							commandRequest.setDepMap(commandItems);
							processor.processCommand(commandRequest);
						}
					}
				}
			} else {
				throw new Exception("Invalid input");
			}
		}
	}

	private static String removeEmptySpaces(String commandCodes) {
		return commandCodes.trim().replaceAll(" +", " ");
	}

	private static boolean contains(String key){
		return CommandEnum.asList().contains(key);
	}

}
