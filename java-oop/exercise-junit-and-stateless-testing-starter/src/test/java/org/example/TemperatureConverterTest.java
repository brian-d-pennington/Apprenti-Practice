package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemperatureConverterTest {
    private TemperatureConverter converter;

    // set up
    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    // test

    @Test
    public void testCelsiusToFahrenheit() {
        // arrange
        double expected = 73.4;
        // act
        double actual = converter.celsiusToFahrenheit(23);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void testFahrenheitToCelsius() {
        // arrange
        double expected = 35;
        // act
        double actual = converter.fahrenheitToCelsius(95);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void testFahrenheitToKelvin() {
        // arrange
        double expected = 293;
        // act
        double actual = converter.fahrenheitToKelvin(67.73);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void testCelsiusToKelvin() {
        // arrange
        double expected = 291;
        // act
        double actual = converter.celsiusToKelvin(17.85);
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void testKelvinToCelsius() {
        // arrange
        double expected = 27.85;
        // act
        double actual = converter.kelvinToCelsius(301);
        BigDecimal bd = new BigDecimal(actual);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        actual = bd.doubleValue();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void testKelvinToFahrenheit() {
        // arrange
        double expected = 1.13;
        // act
        double actual = converter.kelvinToFahrenheit(256);
        BigDecimal bd = new BigDecimal(actual);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        actual = bd.doubleValue();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void testKelvinToFahrenheitNegativeInput() {
        // arrange
        double expected = -1; // error exception
        // act
        double actual = converter.kelvinToFahrenheit(-10.0);
        BigDecimal bd = new BigDecimal(actual);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        actual = bd.doubleValue();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    public void testKelvinToCelsiusNegativeInput() {
        // arrange
        double expected = -1; // error exception
        // act
        double actual = converter.kelvinToCelsius(-25);
        BigDecimal bd = new BigDecimal(actual);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        actual = bd.doubleValue();
        // assert
        assertEquals(expected, actual);
    }


}