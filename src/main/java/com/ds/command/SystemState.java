package com.ds.command;

import com.ds.command.request.InstalledComponent;

import java.util.ArrayList;
import java.util.List;

public class SystemState {

    private static List<InstalledComponent> installedComponentList = new ArrayList<>();

    public static void registerComponent(InstalledComponent installedComponent){
        installedComponentList.add(installedComponent);
    }

    public static List<InstalledComponent> getInstalledComponents(){
        return installedComponentList;
    }
}
