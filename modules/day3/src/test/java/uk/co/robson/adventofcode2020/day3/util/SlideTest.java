package uk.co.robson.adventofcode2020.day3.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlideTest {
    @Test
    public void shouldHitTrees() throws Exception {
        DataParser parser = new DataParser();
        int[][] data = parser.parseFile("test-sample.txt");

        Slide slide = new Slide();
        int hit = slide.treesHit(data, 3, 1);
        assertEquals(11, hit);
    }
}