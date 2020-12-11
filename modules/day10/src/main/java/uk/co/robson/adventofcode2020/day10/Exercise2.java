package uk.co.robson.adventofcode2020.day10;

import uk.co.robson.adventofcode2020.common.BasicFileParser;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {
    public static void main(String[] args) throws Exception {
        BasicFileParser parser = new BasicFileParser();
        List<Integer> items = parser.parseFile("exercise-input.txt", Integer::parseInt);

        long streak = 0;
        long acc = 1;

        List<Integer> sortedItems = items.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        acc = walkItems(sortedItems, 0, 0, streak, acc);
        System.out.println(acc);

    }

    private static long walkItems(List<Integer> items, int prev, int next, long streak, long acc) {
        if (next - prev == 1) {
            streak += 1;
        } else {
            acc = acc * getAccCount(streak);
            streak = 0;
        }

        if(items.indexOf(next + 1) < items.size() - 1) {
            return walkItems(items, next, items.get(items.indexOf(next) + 1), streak, acc);
        }

        return acc;
    }

    // https://en.wikipedia.org/wiki/Lazy_caterer%27s_sequence
    private static long getAccCount(long streak) {
        streak = streak - 1; // only inner part of cluster can be changed - exclude last/first number
        return (streak * streak + streak + 2) / 2;
    }
}
