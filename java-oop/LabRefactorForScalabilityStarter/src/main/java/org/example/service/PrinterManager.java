package org.example.service;

import org.example.model.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrinterManager {
    Map<String, Printer> storePrintersById = new HashMap<>();
    List<PrinterMonitor> trackMonitors = new ArrayList<>();

    public void addPrinter(String name) {
        String sum = Integer.toString(storePrintersById.size() +1);
        storePrintersById.put(sum, new Printer(name));
        trackMonitors.add(new PrinterMonitor(new Printer (name)));
    }

    public List<PrinterMonitor> getTrackMonitors() {
        return trackMonitors;
    }

    public Printer getPrinter(String key) {
        return storePrintersById.get(key);
    }

    public List<String> getAllPrinterIDs() {
        List<String> allPrinterIDs= new ArrayList<>();
        for (String key : storePrintersById.keySet()) {
            allPrinterIDs.add(key);
        }
        return allPrinterIDs;
    }

    public void haltMonitors() {
        for (PrinterMonitor monitor : trackMonitors) {
            monitor.cancel();
        }
    }
}
