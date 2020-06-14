package com.ds.input.processor.impl;

import com.ds.command.SystemState;
import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;
import com.ds.command.request.InstalledComponent;

public class ListCommandProcessor implements CommandProcessor {
	@Override
	public void processCommand(CommandRequest commandReq) {
		if(SystemState.getInstalledComponents()!=null && SystemState.getInstalledComponents().size()>0){
			for (InstalledComponent installedComponent : SystemState.getInstalledComponents()) {
				System.out.println("\t" + installedComponent.getName());
			}
		} else {
			System.out.println("\t No Components installed!");
		}

	}
}
