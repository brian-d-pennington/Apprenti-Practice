package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GiftTest {

    @BeforeEach
    void setUp() {
        Gift testGift = new Gift("watergun", "large");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void setDescription() {
    }

    @Test
    void getSize() {
    }

    @Test
    void setSize() {
    }
}