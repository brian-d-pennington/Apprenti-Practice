package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThermostatTest {
    // set up
    private Thermostat thermostat;
    private final int TARGET_TEMPERATURE = 72;
    private final int TOLERANCE = 2;

    @BeforeEach
    void setUp() {
        thermostat = new Thermostat();
        thermostat.setTargetTemperature(TARGET_TEMPERATURE);
        thermostat.setTolerance(TOLERANCE);
    }
    // assert
        // heat on when temp low
        @Test
        public void heatOnWhenTempLow() {
            // arrange
            int[] temperatures = {72,68,69,70};
            // act
            Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.ON_HEAT;
            Thermostat.ThermostatBehavior actualResult = thermostat.readSensorData(temperatures);
            // assert
            assertEquals(expectedResult, actualResult);
        }
        // ac on when temp high
        @Test
        public void acOnWhenTempLow() {
            // arrange
            int[] temperatures = {82,74,107,212};
            // act
            Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.ON_AC;
            Thermostat.ThermostatBehavior actualResult = thermostat.readSensorData(temperatures);
            // assert
            assertEquals(expectedResult, actualResult);
        }
        // system off when within tolerance
        @Test
        public void systemOffWithinTolerance() {
            // arrange
            int[] temperatures = {71,72,70,69};
            // act
            Thermostat.ThermostatBehavior expectedResult = Thermostat.ThermostatBehavior.OFF;
            Thermostat.ThermostatBehavior actualResult = thermostat.readSensorData(temperatures);
            // assert
            assertEquals(expectedResult, actualResult);
        }

        @Test
        public void getTempReturnsCorrectTemp() {
            // arrange
            // act
            int actual = thermostat.getTargetTemperature();
            // assert
            assertEquals(TARGET_TEMPERATURE, actual);
        }

    @Test
    public void getToleranceReturnsCorrectTolerance() {
        // arrange

        // act
        int actual = thermostat.getTolerance();
        // assert
        assertEquals(TOLERANCE, actual);
    }
    // tear down
}
