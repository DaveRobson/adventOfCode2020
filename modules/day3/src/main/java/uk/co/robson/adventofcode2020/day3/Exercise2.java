package uk.co.robson.adventofcode2020.day3;

import com.google.common.base.Stopwatch;
import uk.co.robson.adventofcode2020.day3.util.DataParser;
import uk.co.robson.adventofcode2020.day3.util.Slide;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();

        DataParser parser = new DataParser();
        int[][] course = parser.parseFile("exercise1-input.txt");
        Slide slide = new Slide();

        long sum = slide.treesHit(course, 1, 1);
        sum *= slide.treesHit(course, 3, 1);
        sum *= slide.treesHit(course, 5, 1);
        sum *= slide.treesHit(course, 7, 1);
        sum *= slide.treesHit(course, 1, 2);

        System.out.println("Num of trees " + sum);
        System.out.println("Time taken to execute: " + stopwatch);
    }
}
