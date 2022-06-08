package com.training.java.maven.base;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class StringCalculator {
    public int Add(String numbers) {
        if(numbers.isEmpty()) return 0;

        if(numbers.contains(",\n"))
            throw new InvalidParameterException();

        var sum = 0;
        var extractedNumbers = Arrays.stream(numbers.split(",|\\n")).map(Integer::parseInt).toArray(Integer[]::new);

        for (Integer extractedNumber : extractedNumbers) sum += extractedNumber;

        return sum;
    }
}
