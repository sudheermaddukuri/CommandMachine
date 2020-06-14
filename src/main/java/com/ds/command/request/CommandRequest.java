package com.ds.command.request;

import java.util.*;

public class CommandRequest {

    String commandCode;

    public String getKeyIdentifier() {
        return keyIdentifier;
    }

    public void setKeyIdentifier(String keyIdentifier) {
        this.keyIdentifier = keyIdentifier;
    }

    String keyIdentifier;
    List<InstalledComponent> installedSet = new ArrayList<>();

    public Map<String, LinkedList<String>> getDepMap() {
        return depMap;
    }

    public void setDepMap(Map<String, LinkedList<String>> depMap) {
        this.depMap = depMap;
    }

    Map<String, LinkedList<String>> depMap = new HashMap<>();
    Map<String, List<String>> revDeps = new LinkedHashMap<>();

    public List<InstalledComponent> getInstalledSet() {
        return installedSet;
    }

    public void setInstalledSet(List<InstalledComponent> installedSet) {
        this.installedSet = installedSet;
    }

    public String getCommandCode() {
        return commandCode;
    }

    public void setCommandCode(String commandCode) {
        this.commandCode = commandCode;
    }


    public Map<String, List<String>> getRevDeps() {
        return revDeps;
    }

    public void setRevDeps(Map<String, List<String>> revDeps) {
        this.revDeps = revDeps;
    }

}
