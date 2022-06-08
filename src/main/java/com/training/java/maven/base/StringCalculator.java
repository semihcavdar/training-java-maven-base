package com.training.java.maven.base;

public class StringCalculator {
    public int Add(String numbers) {
        if(numbers.isEmpty()) return 0;

        if(numbers.split(",").length == 1)
            return Integer.parseInt(numbers);

        return 0;
    }
}
