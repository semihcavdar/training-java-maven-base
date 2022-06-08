package com.training.java.maven.base;

public class StringCalculator {
    public int Add(String numbers) {
        if(numbers.isEmpty()) return 0;

        var extractedNumbers = numbers.split(",");

        if(extractedNumbers.length == 1)
            return Integer.parseInt(numbers);

        if(extractedNumbers.length == 2)
            return Integer.parseInt(extractedNumbers[0]) + Integer.parseInt(extractedNumbers[1]);

        return 0;
    }
}
