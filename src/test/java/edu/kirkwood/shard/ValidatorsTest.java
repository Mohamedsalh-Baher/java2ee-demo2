package edu.kirkwood.shard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ValidatorsTest {
    @Test
    void testIsANumber() {
        assertTrue(Validators.isANumber("123"));
        assertTrue(Validators.isANumber("123.45"));
        assertFalse(Validators.isANumber("abc"));
        assertFalse(Validators.isANumber("123abc"));
        assertFalse(Validators.isANumber(""));
    }

    @Test
    void testIsValidEmail() {
        assertTrue(Validators.isValidEmail("test@example.com"));
        assertTrue(Validators.isValidEmail("user.name+tag@domain.co"));
        assertFalse(Validators.isValidEmail("plainaddress"));
        assertFalse(Validators.isValidEmail("missing@domain"));
        assertFalse(Validators.isValidEmail("user@.com"));
    }
  
}