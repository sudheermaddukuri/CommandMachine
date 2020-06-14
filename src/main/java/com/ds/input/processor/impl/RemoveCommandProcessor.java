package com.ds.input.processor.impl;

import java.util.LinkedList;
import java.util.List;

import com.ds.command.SystemState;
import com.ds.command.processor.CommandProcessor;
import com.ds.command.request.CommandRequest;
import com.ds.command.request.InstalledComponent;

public class RemoveCommandProcessor implements CommandProcessor {

    @Override
    public void processCommand(CommandRequest req) {
        if (SystemState.getInstalledComponents().contains(new InstalledComponent(req.getKeyIdentifier()))) {
            LinkedList<String> revDepsList = req.getDepMap().values().stream().filter(x -> x.contains(req.getKeyIdentifier())).findFirst().orElse(null);

            if (revDepsList != null && revDepsList.size() > 0) {
                System.out.println("\t" + req.getKeyIdentifier() + " is still needed");
            } else {
                removeDependency(req.getKeyIdentifier(), req, true);
            }

        } else {
            System.out.println("\t" + req.getKeyIdentifier() + " is not installed");
        }
    }

    public static boolean removeDependency(String comp, CommandRequest req, boolean isExplicit) {
        List<String> deps = req.getDepMap().get(req.getKeyIdentifier());

        int index = SystemState.getInstalledComponents().indexOf(new InstalledComponent(comp));
        InstalledComponent currentComponent = SystemState.getInstalledComponents().get(index);
        if ((deps == null || deps.isEmpty()) && index > -1
                && (isExplicit || !currentComponent.getIsExplicit())) {
            System.out.println("\tRemoving " + comp);
            SystemState.getInstalledComponents().remove(currentComponent );
            List<String> comps = req.getDepMap().get(comp);
            /*if (comps != null) {
                comps.forEach(depn -> {
                    List<String> get = req.getRevDeps().get(depn);
                    if (get != null && !get.isEmpty()) {
                        get.remove(comp);
                    }
                    removeDependency(depn, req, false);
                });
            }*/
        }
        return false;
    }
}
