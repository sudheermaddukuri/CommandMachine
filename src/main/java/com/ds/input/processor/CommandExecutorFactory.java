package com.ds.input.processor;

import com.ds.command.processor.CommandProcessor;
import com.ds.input.processor.impl.EndCommandProcessor;
import com.ds.input.processor.impl.InstallCommandProcessor;
import com.ds.input.processor.impl.ListCommandProcessor;
import com.ds.input.processor.impl.RemoveCommandProcessor;
import com.ds.input.validator.CommandEnum;

public class CommandExecutorFactory {

	public static CommandProcessor getCommandProcessor(String commandCode) {
		if(CommandEnum.INSTALL.name().equals(commandCode)) {
			return new InstallCommandProcessor();
		} else if(CommandEnum.LIST.name().equals(commandCode)) {
			return new ListCommandProcessor();
		} else if(CommandEnum.REMOVE.name().equals(commandCode)){
			return new RemoveCommandProcessor();
		} else if(CommandEnum.END.name().equals(commandCode)) {
			return new EndCommandProcessor();
		}
		
		return null;
	}
}
