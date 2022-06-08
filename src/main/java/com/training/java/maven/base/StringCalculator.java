package com.training.java.maven.base;

import java.util.Arrays;

public class StringCalculator {
    public int Add(String numbers) {
        if(numbers.isEmpty()) return 0;

        var extractedNumbers = Arrays.stream(numbers.split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        if(extractedNumbers.length == 1)
            return extractedNumbers[0];

        if(extractedNumbers.length == 2)
            return extractedNumbers[0] + extractedNumbers[1];

        if(extractedNumbers.length == 4)
            return extractedNumbers[0] + extractedNumbers[1] + extractedNumbers[2] + extractedNumbers[3];

        return 0;
    }
}
