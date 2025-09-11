package org.example.view;

import org.example.model.Printer;
import org.example.service.PrinterManager;
import org.example.service.PrinterMonitor;

import java.util.List;

public class MenuController {
    PrinterManager printerManager = new PrinterManager();
    List<String> ids;
    ConsoleIO io = ConsoleIO.getInstance();
    Printer.PrinterStatus status;
    Printer printer;
    PrinterMonitor printerMonitor;
    List<PrinterMonitor> trackMonitors;


    // main menu logic
    public void run() {
        boolean running = true;

        io.displayMessage("Printer monitor online");
        printerManager.addPrinter("Default printer");
        ids = printerManager.getAllPrinterIDs();
        printerMonitor = new PrinterMonitor(printerManager.getPrinter("1"));

        while (running) {
            io.displayMessage("[D]isplay printer status");
            io.displayMessage("[A]dd printer");
            io.displayMessage("[P]rint an object");
            io.displayMessage("[C]lear the print bed");
            io.displayMessage("e[X]it");
            String choice = io.getStringRequired("");

            switch (choice) {
                case "D":
                    display();
                    break;
                case "P":
                    printerReady();
                    printerSelected();
                    break;
                case "A":
                    String printerName = io.getStringRequired("Enter name of printer to add:");
                    printerManager.addPrinter(printerName);
                    ids = printerManager.getAllPrinterIDs();
                    trackMonitors = printerManager.getTrackMonitors();
                    break;
                case "C":
                    for (String id : ids) {
                        io.displayMessage("Retrieving " + printerManager.getPrinter(id).getName());
                    }
                    clear();
                    display();
                    break;
                case "X":
                    printerManager.haltMonitors(); // does nothing
                    running = false;
                    break;
            }
        }
        io.displayMessage("Halting printer monitors");
        io.displayMessage("Goodbye!");
        System.exit(0);

    }

    public void display(){
        for (String id : ids) {
            io.displayMessage(printerManager.getPrinter(id).getName());
            status = printerManager.getPrinter(id).getStatus();
            io.displayMessage(status.toString());
        }
    }

    public void printerSelected() {
        String printerChoice;
        while(true){
            printerChoice = io.getStringRequired("Enter by printer ID: ");
            if (printerManager.getPrinter(printerChoice) != null) {
                String file = io.getStringRequired("Object to print");
                printer.print(file);
                trackMonitors.get(Integer.parseInt(printerChoice) -1).run();
                break;
            } else {
                io.displayMessage("That is not an available printer. Try again.");
            }
        }
    }

    public void printerReady() {
        boolean ready = false;
        for (String id : ids) {
            printer = printerManager.getPrinter(id);
            if (printer.getStatus().equals(Printer.PrinterStatus.READY)) {
                io.displayMessage("Printer id: " + id + " name: " + printer.getName() + " is available to print.");
                ready = true;
            }
        }
        if (!ready) {
            io.displayMessage("No printers are currently available. Try again later.");
        }
    }

    public void clear(){
        for (String id : ids) {
            printerManager.getPrinter(id).setStatus(Printer.PrinterStatus.READY);
        }
    }
}
