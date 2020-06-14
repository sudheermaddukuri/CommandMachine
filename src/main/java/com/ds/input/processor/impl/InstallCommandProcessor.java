package com.ds.input.processor.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.ds.command.SystemState;
import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;
import com.ds.command.request.InstalledComponent;

public class InstallCommandProcessor implements CommandProcessor {

    @Override
    public void processCommand(CommandRequest req) {
        if (SystemState.getInstalledComponents().contains(new InstalledComponent(req.getKeyIdentifier()))) {
            System.out.println("\t" + req.getKeyIdentifier() + " is already installed.");
        } else {
            resolveDependencies(req.getKeyIdentifier(), req, true);
        }
    }

    public static void resolveDependencies(String comp, CommandRequest req, boolean isExplicit) {
        if (!SystemState.getInstalledComponents().contains(new InstalledComponent(comp))) {
            LinkedList<String> deps = req.getDepMap().get(comp);
            if (deps != null && !deps.isEmpty()) {
                Iterator listIterator = deps.listIterator();
                while(listIterator.hasNext()){
                    String dependency = (String)listIterator.next();
                    SystemState.registerComponent(new InstalledComponent(comp, isExplicit));
                    System.out.println("\tInstalling " + dependency);
                }
            }
        }
    }
}
