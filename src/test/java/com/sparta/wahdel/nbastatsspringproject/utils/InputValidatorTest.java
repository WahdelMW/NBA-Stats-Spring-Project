package com.sparta.wahdel.nbastatsspringproject.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    public void invalidUsernameContainsSpecialCharacter() {
        Assertions.assertFalse(InputValidator.isValidUsername("!admin"));
    }

    @Test
    public void invalidUsernameContainsWhiteSpace() {
        Assertions.assertFalse(InputValidator.isValidUsername("!admin"));
    }

    @Test
    public void invalidUsernameAll() {
        Assertions.assertFalse(InputValidator.isValidUsername("@ 0"));
    }

}
