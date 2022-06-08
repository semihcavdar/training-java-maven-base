package com.training.java.maven.base;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
    public int Add(String numbers) {
        var sum = 0;
        if(numbers.isEmpty()) return sum;

        if(numbers.contains(",\n"))
            throw new InvalidParameterException();

        if(numbers.startsWith("//")) {
            var seperatedByNewLine = numbers.split("\n");
            var delimiters = seperatedByNewLine[0].split("//")[1];

            var extractedNumbers = Arrays.stream(seperatedByNewLine[1].split(delimiters + "|" + ";")).map(Integer::parseInt).toArray(Integer[]::new);
            for (Integer extractedNumber : extractedNumbers) sum += extractedNumber;

            return sum;
        }

        var extractedNumbers = Arrays.stream(numbers.split(",|\\n")).map(Integer::parseInt).toArray(Integer[]::new);
        var negativeNumbers = new ArrayList<Integer>();
        for (Integer extractedNumber : extractedNumbers) {
            if(extractedNumber < 0){
                negativeNumbers.add(extractedNumber);
            }
            sum += extractedNumber;
        }
        if(!negativeNumbers.isEmpty()) {
            if(negativeNumbers.size() == 1) {
                throw new InvalidParameterException("negatives not allowed: " + negativeNumbers.get(0));
            } else {
                throw new InvalidParameterException(Stream.of(negativeNumbers)
                    .map(String::valueOf)
                    .collect( Collectors.joining(",")));
             //   throw new InvalidParameterException("negatives not allowed: " + negativeNumbers.stream().map(String::valueOf).reduce("", (a, b) -> a + ", " + b));
            }
        }

        return sum;
    }
}
