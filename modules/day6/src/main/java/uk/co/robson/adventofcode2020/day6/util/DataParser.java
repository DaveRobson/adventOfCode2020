package uk.co.robson.adventofcode2020.day6.util;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    public List<String> parseFile(String name) throws Exception {
        String[] rawLines = loadInputData(name).split("\n\\s*\n");
        return Arrays.stream(rawLines)
                .collect(Collectors.toList());
    }

    private String loadInputData(String name) throws Exception {
        InputStream stream = DataParser.class.getClassLoader().getResourceAsStream(name);
        return IOUtils.toString(stream, StandardCharsets.UTF_8);
    }
}
