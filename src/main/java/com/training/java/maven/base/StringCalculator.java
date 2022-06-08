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
            throw new InvalidParameterException("negatives not allowed: " + Arrays.toString(negativeNumbers.toArray()).replaceAll("\\[|\\]|\\s", ""));
        }

        return sum;
    }
}
