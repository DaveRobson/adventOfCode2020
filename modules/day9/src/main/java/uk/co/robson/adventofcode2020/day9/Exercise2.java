package uk.co.robson.adventofcode2020.day9;

import uk.co.robson.adventofcode2020.day9.util.DataParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        List<Long> values = parser.parseFile("exercise-input.txt");

        Long xmasNumber = 177777905L;
        int xmasIndex = values.indexOf(xmasNumber);
        System.out.println("xmasRange: " + Exercise2.xmasRange(values, xmasIndex));
    }

    private static Long xmasRange(List<Long> values, int xmasIndex) {
        Long currentValue = values.get(xmasIndex);
        List<Long> xmasList = new ArrayList<>();
        for(int i = xmasIndex - 1; i >= 0; i--) {
            xmasList = new ArrayList<>();
            Long sum = values.get(i);
            xmasList.add(sum);

            for(int j = i - 1; j >= 0; j--) {
                Long inner = values.get(j);

                if(sum < currentValue && inner + sum <= currentValue) {
                    sum += inner;
                    xmasList.add(inner);
                } else {
                    break;
                }
            }

            if(sum.equals(currentValue)) {
                break;
            }
        }

        List<Long> sorted = xmasList.stream()
                .sorted(Long::compareTo)
                .collect(Collectors.toList());

        System.out.println(sorted.toString());
        return sorted.get(0) + sorted.get(sorted.size() - 1);
    }
}
