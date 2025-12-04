package org.example;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @org.junit.jupiter.api.Test
    void isValidId() {
        assertTrue(Validator.isValidId("234"));
        assertTrue(Validator.isValidId("001"));
        assertTrue(Validator.isValidId("3"));

        assertFalse(Validator.isValidId("fsr3"));
        assertFalse(Validator.isValidId("3 5"));
        assertFalse(Validator.isValidId("0-3id-2"));
    }

    @org.junit.jupiter.api.Test
    void isValidName() {
        assertTrue(Validator.isValidName("Caleb"));
        assertTrue(Validator.isValidName("Malbonte"));
        assertTrue(Validator.isValidName("Cardan"));

        assertFalse(Validator.isValidName("Caleb Summers"));
        assertFalse(Validator.isValidName("Mal-Bont"));
        assertFalse(Validator.isValidName("C0rda4"));
    }

    @org.junit.jupiter.api.Test
    void isValisAverage() {
        assertTrue(Validator.isValidAverage("5.0"));
        assertTrue(Validator.isValidAverage("3.5"));
        assertTrue(Validator.isValidAverage("3.0"));

        assertFalse(Validator.isValidAverage("6.0"));
        assertFalse(Validator.isValidAverage("0.0"));
        assertFalse(Validator.isValidAverage("1.0"));
    }
}