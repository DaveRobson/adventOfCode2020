package uk.co.robson.adventofcode2020.day6;

import uk.co.robson.adventofcode2020.day6.util.DataParser;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Exercise1 {
    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        List<String> lines = parser.parseFile("exercise-input.txt");
        Optional<Integer> count = lines.stream()
                .map(line -> line.replace("\n", ""))
                .map(line -> Arrays.stream(line.split("")).distinct().collect(Collectors.joining()))
                .map(String::length)
                .reduce((current, total) -> total += current);

        System.out.println("Count of yes answers: " + count);
    }
}
