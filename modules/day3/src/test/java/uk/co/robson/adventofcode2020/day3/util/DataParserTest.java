package uk.co.robson.adventofcode2020.day3.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {

    @Test
    public void shouldParseFile() throws Exception {
        DataParser parser = new DataParser();
        int[][] data = parser.parseFile("exercise1-input.txt");
        assertArrayEquals(data[0], new int[]{0,0,1,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,1,0,0,1,0,1,0,0,0});
    }
}