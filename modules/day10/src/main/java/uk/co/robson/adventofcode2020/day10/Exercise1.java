package uk.co.robson.adventofcode2020.day10;

import uk.co.robson.adventofcode2020.common.BasicFileParser;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<Integer> items = parser.parseFile("exercise-input.txt", Integer::parseInt);

        List<Integer> sortedItems = items.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());


        System.out.println("1-jolt differences multiplied by the number of 3-jolt differences: " + sumDifferences(sortedItems));
    }

    public static int sumDifferences(List<Integer> sortedItems) {
        int sum1 = sortedItems.get(0) == 1 ? 1 : 0;
        int sum3 = sortedItems.get(0) == 3 ? 2 : 1;

        for(int i = 0; i < sortedItems.size() - 1; i++) {
            int current = sortedItems.get(i);
            int next = sortedItems.get(i + 1);

            if((next - current) == 1) {
                sum1 += 1;
            }

            if((next - current) == 3) {
                sum3 += 1;
            }
        }

        return sum1 * sum3;
    }
}
