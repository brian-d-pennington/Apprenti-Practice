package org.example;

import org.example.view.MenuController;

/**
 * App class for the 3D Printer Manager Application
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MenuController menuController = new MenuController();

        menuController.run();
    }
}
