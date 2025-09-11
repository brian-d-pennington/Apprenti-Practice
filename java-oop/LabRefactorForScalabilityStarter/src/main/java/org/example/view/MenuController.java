package org.example.view;

import org.example.service.PrinterManager;

import java.util.List;

public class MenuController {
    PrinterManager printerManager = new PrinterManager();
//    ● Move menu logic from App into a new MenuController class.
//            ● Implement the following methods:
//            ○ display(): Shows the status of all printers.
//            ○ add(): Adds a new printer.
//○ print(): Initiates a print job.
//            ○ clear(): Clears a print bed after completion.
//            ● Ensure all menu logic is removed from App class.
    public void display(){
       List<String> ids = printerManager.getAllPrinterIDs();
       for (String id : ids) {
           System.out.println(printerManager.getPrinter(id).getStatus());
       }
    }

    public void add(){

    }
    public void clear(){

    }

}
