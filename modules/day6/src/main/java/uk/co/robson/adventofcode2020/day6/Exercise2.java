package uk.co.robson.adventofcode2020.day6;

import uk.co.robson.adventofcode2020.day6.util.DataParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Exercise2 {
    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        List<String> lines = parser.parseFile("exercise-input.txt");
        Optional<Long> count = lines.stream()
                .map(Exercise2::groupCount)
                .reduce((current, total) -> total += current);

        System.out.println("Count of yes answers: " + count);
    }

    public static long groupCount(String group) {
        Map<String, Integer> counter = new HashMap<>();

        String[] lines = group.split("\n");
        int numInGroup = lines.length;
        for(String line : lines) {
            String[] letters = line.split("");
            for(String letter : letters) {
                counter.putIfAbsent(letter, 1);
                counter.computeIfPresent(letter, (key, current) -> current += 1);
            }
        }

        return counter.values().stream()
                .filter(value -> value > numInGroup)
                .count();

    }
}
