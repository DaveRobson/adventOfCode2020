package uk.co.robson.adventofcode2020.day2.util;

import org.junit.Test;
import uk.co.robson.adventofcode2020.day2.domain.PasswordData;

import static org.junit.Assert.assertEquals;

public class FileParserTest  {

    @Test
    public void shouldParseLine() {
        FileParser fileParser = new FileParser();
        PasswordData passwordData = fileParser.parseLine("2-4 r: prrmspx");

        assertEquals(2, passwordData.getStartRange());
        assertEquals(4, passwordData.getEndRange());
        assertEquals("r", passwordData.getPolicy());
        assertEquals("prrmspx", passwordData.getValue());
    }
}