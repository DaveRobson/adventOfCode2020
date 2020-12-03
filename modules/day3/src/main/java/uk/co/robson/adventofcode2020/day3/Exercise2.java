package uk.co.robson.adventofcode2020.day3;

import uk.co.robson.adventofcode2020.day3.util.DataParser;
import uk.co.robson.adventofcode2020.day3.util.Slide;

import java.math.BigInteger;
import java.util.List;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        int[][] course = parser.parseFile("exercise1-input.txt");
        Slide slide = new Slide();

        long sum = slide.treesHit(course, 1, 1);
        sum *= slide.treesHit(course, 3, 1);
        sum *= slide.treesHit(course, 5, 1);
        sum *= slide.treesHit(course, 7, 1);
        sum *= slide.treesHit(course, 1, 2);

        System.out.println("Num of trees " + sum);
    }
}
