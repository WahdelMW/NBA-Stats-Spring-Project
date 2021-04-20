package com.sparta.wahdel.nbastatsspringproject.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InputValidatorTest {

    @Test
    public void validUsername() {
        Assertions.assertTrue(InputValidator.isValidUsername("admin"));
    }

    @Test
    public void validUsernameWithNumbers() {
        Assertions.assertTrue(InputValidator.isValidUsername("admin91345"));
    }

    @Test
    public void invalidUsernameLessThan5() {
        Assertions.assertFalse(InputValidator.isValidUsername("ad"));
    }

    @Test
    public void invalidUsernameNoLetters() {
        Assertions.assertFalse(InputValidator.isValidUsername("12345"));
    }

    @Test
    public void invalidUsernameContainsSpecialCharacter() {
        Assertions.assertFalse(InputValidator.isValidUsername("!admin"));
    }

    @Test
    public void invalidUsernameContainsWhiteSpace() {
        Assertions.assertFalse(InputValidator.isValidUsername("!admin"));
    }

    @Test
    public void invalidUsername() {
        Assertions.assertFalse(InputValidator.isValidUsername("@ 0"));
    }

    @Test
    public void validPassword() {
        Assertions.assertTrue(InputValidator.isValidPassword("P@ssw0rd"));
    }

    @Test
    public void invalidPasswordLessThan8() {
        Assertions.assertFalse(InputValidator.isValidPassword("P@ssw0r"));
    }

    @Test
    public void invalidPasswordNoUppercase() {
        Assertions.assertFalse(InputValidator.isValidPassword("p@ssw0rd"));
    }

    @Test
    public void invalidPasswordNoLowercase() {
        Assertions.assertFalse(InputValidator.isValidPassword("P@SSW0RD"));
    }

    @Test
    public void invalidPasswordNoNumber() {
        Assertions.assertFalse(InputValidator.isValidPassword("P@ssword"));
    }

    @Test
    public void invalidPasswordNoSpecialCharacter() {
        Assertions.assertFalse(InputValidator.isValidPassword("Passw0rd"));
    }

    @Test
    public void invalidPasswordHasWhiteSpace() {
        Assertions.assertFalse(InputValidator.isValidPassword("P@ss w0rd"));
    }

    @Test
    public void invalidPassword() {
        Assertions.assertFalse(InputValidator.isValidPassword("password"));
    }
}
