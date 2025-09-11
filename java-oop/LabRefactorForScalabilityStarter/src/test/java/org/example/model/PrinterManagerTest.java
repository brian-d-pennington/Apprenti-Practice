package org.example.model;

import org.example.service.PrinterManager;
import org.example.service.PrinterMonitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrinterManagerTest {
    Map<String, Printer> storePrintersById = new HashMap<>();
    PrinterManager printerManager = new PrinterManager();

    @BeforeEach
    void setUp() {
        storePrintersById.put("1", new Printer("OfficePrinter"));
        storePrintersById.put("2", new Printer("AtticPrinter"));
        storePrintersById.put("3", new Printer("BasementPrinter"));
    }

    @Test
    void testAddingPrintersWorks() {
        //Arrange
        //done

        //ACT
        printerManager.addPrinter("KitchenPrinter");

        //ASSERT
        String answer = storePrintersById.keySet().toString();
        assertEquals("[1, 2, 3]", answer);
    }

    @Test
    void getTrackMonitors_initiallyEmpty() {
    // Act
    List<PrinterMonitor> monitors = printerManager.getTrackMonitors();
    // Assert
    assertNotNull(monitors, "Should not return null");
    assertTrue(monitors.isEmpty(), "New manager should start with no monitors");
    }
}
