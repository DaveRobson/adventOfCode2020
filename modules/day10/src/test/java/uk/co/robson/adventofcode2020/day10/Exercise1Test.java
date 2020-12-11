package uk.co.robson.adventofcode2020.day10;

import org.junit.jupiter.api.Test;
import uk.co.robson.adventofcode2020.common.BasicFileParser;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Exercise1Test {

    @Test
    public void shouldSumDifferences() throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<Integer> items = parser.parseFile("sample-data.txt", Integer::parseInt);

        List<Integer> sortedItems = items.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        int value = Exercise1.sumDifferences(sortedItems);
        assertEquals(220, value);
    }
}