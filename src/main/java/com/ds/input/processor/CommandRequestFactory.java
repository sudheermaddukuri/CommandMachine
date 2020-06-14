package com.ds.input.processor;

import com.ds.command.request.CommandRequest;
import com.ds.command.request.InstallCommandRequest;
import com.ds.command.request.ListCommandRequest;
import com.ds.command.request.RremoveCommandRequest;
import com.ds.input.validator.CommandEnum;

public class CommandRequestFactory {

	public static CommandRequest getCommandRequest(String commandCode) {
		if(CommandEnum.INSTALL.name().equals(commandCode)) {
			return new InstallCommandRequest();
		} else if(CommandEnum.LIST.name().equals(commandCode)) {
			return new ListCommandRequest();
		} else if(CommandEnum.REMOVE.name().equals(commandCode)){
			return new RremoveCommandRequest();
		} else if(CommandEnum.END.name().equals(commandCode)) {
			return new CommandRequest();
		}
		
		return null;
	}
}
