package uk.co.robson.adventofcode2020.day3;

import uk.co.robson.adventofcode2020.day3.util.DataParser;
import uk.co.robson.adventofcode2020.day3.util.Slide;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        int[][] course = parser.parseFile("exercise1-input.txt");
        Slide slide = new Slide();

        System.out.println("Num of trees " + slide.treesHit(course, 3, 1));
    }

}
