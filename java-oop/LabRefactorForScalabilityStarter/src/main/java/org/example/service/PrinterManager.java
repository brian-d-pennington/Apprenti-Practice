package org.example.service;

import org.example.model.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrinterManager {
    Map<String, Printer> storePrintersById;
    List<PrinterMonitor> trackMonitors;

//    public void addPrinter(String key, Printer printer) {
//        storePrintersById.put(key, printer);
//    }
    // overloaded method that takes no parameters
    public void addPrinter(String name) {
        String sum = Integer.toString(storePrintersById.size() +1);
        storePrintersById.put(sum, new Printer(name));
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

    }
}
