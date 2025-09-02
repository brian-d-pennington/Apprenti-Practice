package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    ShoppingCart testCart;
    Item[] testItems;
    Item testItem1;
    Item testItem2;
    Item testItem3;
    double itemsTotal;

    @BeforeEach
    public void setup() {
        testItem1 = new Item();
        testItem1.setName("Spinny Top");
        testItem1.setPrice(2.00);

        testItem2 = new Item();
        testItem2.setName("Protective Eyewear");
        testItem2.setPrice(10.00);

        testItem3 = new Item();
        testItem3.setName("Red Ryder BB Gun");
        testItem3.setPrice(50.00);

        testItems = new Item[3];
        testItems[0] = testItem1;
        testItems[1] = testItem2;
        testItems[2] = testItem3;

        testCart = new ShoppingCart();
    }

    @Test
    void checkoutShoppingCart() { // refactored cart just gets the item total
        double expected = 62.00;
        double precision = .001;
        // Because binary math and decimal math don't always work out precisely the same
        // assertEquals for floating point numbers allows a third parameter for specifying
        // "close enough".  In this case, .001 means we will be accurate to a tenth of a cent.
        itemsTotal = testCart.checkoutShoppingCart(testItems);
        assertEquals(expected, itemsTotal, precision);
    }

    // test apply discount
    @Test
    void applyDiscount() {
        Discount discount = new Discount();
        discount.setDiscountCode(.30);
        double expected = 43.40;
        double precision = .001;
        itemsTotal = testCart.checkoutShoppingCart(testItems);
        double output = discount.applyDiscount(itemsTotal, discount.getDiscountCode());
        assertEquals(expected, output, precision);
    }

    // test apply tax
    @Test
    void applyTaxRate() {
        Tax tax = new Tax();
        tax.setTaxRate(.07);
        double expected = 66.34;
        double precision = .001;
        itemsTotal = testCart.checkoutShoppingCart(testItems);
        double output = tax.applyTaxRate(itemsTotal, tax.getTaxRate());
        assertEquals(expected, output, precision);
    }

    // a "unit test" that applies discount and taxes
    @Test
    void discountShoppingCartScenario() {
        Discount discount = new Discount();
        Tax tax = new Tax();
        discount.setDiscountCode(.50);
        tax.setTaxRate(.12); // Chicago sales tax :(
        double expected = 34.72;
        double precision = .001;

        itemsTotal = testCart.checkoutShoppingCart(testItems);
        double discountTotal = discount.applyDiscount(itemsTotal, discount.getDiscountCode());
        double output = tax.applyTaxRate(discountTotal, tax.getTaxRate());
        assertEquals(expected, output, precision);
    }
}