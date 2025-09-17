package org.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class VendingMachineBinTest {
    VendingMachineBin vmb = new VendingMachineBin();

    Product apple = new Product();

    @BeforeEach
    void setUp() {
        apple.setItemName("Apple");
        apple.setPrice(.25);
    }

    @Test
    void vendProductCorrectAmount() {
        // arrange
        int expected = 0;
        // act
            // load 5 apples, recreating bug
        vmb.loadProduct(apple);
        vmb.loadProduct(Product.clone(apple));
        vmb.loadProduct(Product.clone(apple));
        vmb.loadProduct(Product.clone(apple));
        vmb.loadProduct(Product.clone(apple));
            // vend 5 products
        vmb.vendProduct();
        vmb.vendProduct();
        vmb.vendProduct();
        vmb.vendProduct();
        vmb.vendProduct();
        // assert
        assertEquals(expected, vmb.getProducts().size()); // vending 5 products should equal zero without crashing
    }
}