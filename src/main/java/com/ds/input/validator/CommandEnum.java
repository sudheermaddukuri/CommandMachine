package com.ds.input.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CommandEnum {
	DEPEND (false), INSTALL(true), REMOVE(true), LIST(true), END(true);
	private boolean isExecutable;
	CommandEnum(boolean isExecutable) {
		this.isExecutable = isExecutable;
	}

	public boolean isExecutable() {
		return isExecutable;
	}


	public static List<String> asList() {
		List<String> list = new ArrayList<>();
		for (CommandEnum com : CommandEnum.values()) {
			list.add(com.name());
		}
		return list;
	}

}
