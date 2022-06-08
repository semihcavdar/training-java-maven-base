package com.training.java.maven.base;

import java.util.Arrays;

public class StringCalculator {
    public int Add(String numbers) {
        if(numbers.isEmpty()) return 0;

        var sum = 0;
        var extractedNumbers = Arrays.stream(numbers.split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        for (Integer extractedNumber : extractedNumbers) sum += extractedNumber;

        return sum;
    }
}
