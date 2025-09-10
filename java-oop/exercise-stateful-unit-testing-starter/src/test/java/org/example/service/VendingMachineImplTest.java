package org.example.service;

import org.example.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineImplTest {
    VendingMachine vm;
    static Product apple;
    static Product candyBar;
    static Product soda;

    @BeforeAll
    static void buildProducts() {
        apple = new Product("Apple", .50);
        candyBar = new Product("Candy Bar", 1.00);
        soda = new Product("Soda", 2.50);
    }

    @BeforeEach
    void setUp() {
        vm = new VendingMachineImpl();
        vm.loadProduct("1", apple, 3);
        vm.loadProduct("2", candyBar, 3);
        vm.loadProduct("3", soda, 3);

        vm.addMoney(15.00);
    }

    @Test
    void vendLastItem(){
        // arrange

        // act
        vm.vend("1");
        // assert
        assertEquals(2, vm.getBinQuantity("1"));
    }

    @Test
    void testMoneyBinPurchase(){
        // arrange

        // act
        vm.vend("2");
        // assert
        assertEquals(1.00, vm.getMoneyBinContents());
    }

    @Test
    void loadCorrectProductAmount() {
        // arrange

        // act

        // assert
        assertEquals(3, vm.getBinQuantity("1"));
        assertEquals(3, vm.getBinQuantity("2"));
        assertEquals(3, vm.getBinQuantity("3"));
    }
}