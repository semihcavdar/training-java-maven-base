package com.training.java.maven.base;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ATest {

    @Test
    void should_return_0_when_parameter_is_empty() {
        var stringCalculator = new StringCalculator();
        assertEquals(0,stringCalculator.Add(""));
    }
}
