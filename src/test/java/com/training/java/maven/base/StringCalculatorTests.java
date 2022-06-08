package com.training.java.maven.base;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        var parameter = "1,2";

        // when
        var result = stringCalculator.Add(parameter);

        // then
        assertEquals(3, result);
    }

    @Test
    void should_return_sum_of_four_numbers() {
        // given
        var stringCalculator = new StringCalculator();
        var parameter = "1,2,3,4";

        // when
        var result = stringCalculator.Add(parameter);

        // then
        assertEquals(10, result);
    }

    @Test
    void should_return_sum_of_six_numbers() {
        // given
        var stringCalculator = new StringCalculator();
        var parameter = "1,2,3,4,5,6";

        // when
        var result = stringCalculator.Add(parameter);

        // then
        assertEquals(21, result);
    }

    @Test
    void should_return_sum_of_three_numbers_separated_by_newline() {
        // given
        var stringCalculator = new StringCalculator();
        var parameter = "1\n2,3";

        // when
        var result = stringCalculator.Add(parameter);

        // then
        assertEquals(6, result);
    }

    @Test
    void should_throw_exception_when_comma_and_newline_following_each_other() {
        // given
        var stringCalculator = new StringCalculator();
        var parameter = "1,\n";

        // when && then
        Assertions.assertThrows(InvalidParameterException.class, ()->stringCalculator.Add(parameter));
    }

    @Test
    void should_return_3_when_parameters_1_and_2_and_delimiter_is_semicolon() {
        // given
        var stringCalculator = new StringCalculator();
        var parameter = "//;\n1;2";

        // when
        var result = stringCalculator.Add(parameter);

        // then
        assertEquals(3, result);
    }

    @Test
    void should_return_6_when_parameters_1_and_2_and_3_and_delimiter_is_exclamation_mark() {
        // given
        var stringCalculator = new StringCalculator();
        var parameter = "//!\n1!2!3";

        // when
        var result = stringCalculator.Add(parameter);

        // then
        assertEquals(6, result);
    }

    @Test
    void should_throw_an_exception_for_a_negative_number() {
        // given
        var stringCalculator = new StringCalculator();
        var parameter = "1,2,-3";

        // when
        InvalidParameterException thrown = Assertions.assertThrows(InvalidParameterException.class, () -> stringCalculator.Add(parameter));

        // then
        Assertions.assertEquals("negatives not allowed: -3", thrown.getMessage());
    }
}
