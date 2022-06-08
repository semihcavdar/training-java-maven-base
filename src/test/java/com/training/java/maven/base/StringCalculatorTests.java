package com.training.java.maven.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StringCalculatorTests {

    @Test
    void should_return_0_when_parameter_is_empty() {
        var stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.Add(""));
    }

    @Test
    void should_return_passed_parameter() {
        // given
        var stringCalculator = new StringCalculator();
        var parameter = "5";

        // when
        var result = stringCalculator.Add(parameter);

        // then
        assertEquals(Integer.parseInt(parameter), result);
    }

    @Test
    void should_return_sum_of_test_parameters() {
        // given
        var stringCalculator = new StringCalculator();
        var parameter = "1, 2";

        // when
        var result = stringCalculator.Add(parameter);

        // then
        assertEquals(3, result);
    }
}
