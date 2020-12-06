package uk.co.robson.adventofcode2020.day6.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {
    @Test
    public void shouldParseFile() throws Exception {
        DataParser parser = new DataParser();
        List<String> lines = parser.parseFile("exercise-sample.txt");

        assertEquals("ybcgtxznorvjel\nbrlyvoexnjtgcz\nlnbgtxvoiyecjrz", lines.get(0));
    }
}