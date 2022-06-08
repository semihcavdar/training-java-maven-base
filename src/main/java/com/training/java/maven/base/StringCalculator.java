package com.training.java.maven.base;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class StringCalculator {
    public int Add(String numbers) {
        var sum = 0;
        if(numbers.isEmpty()) return sum;

        if(numbers.contains(",\n"))
            throw new InvalidParameterException();

        var extractedNumbers = Arrays.stream(numbers.split(",|\\n")).map(Integer::parseInt).toArray(Integer[]::new);

        for (Integer extractedNumber : extractedNumbers) sum += extractedNumber;

        return sum;
    }
}
