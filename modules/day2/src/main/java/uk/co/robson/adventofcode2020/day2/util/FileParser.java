package uk.co.robson.adventofcode2020.day2.util;

import org.apache.commons.io.IOUtils;
import uk.co.robson.adventofcode2020.day2.domain.PasswordData;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileParser {

    public List<PasswordData> parseFile() throws Exception {
        String[] lines = loadInputData().split("\n");
        return Arrays.stream(lines)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    public PasswordData parseLine(String line) {
        String[] columns = line.split(" ");
        String range = columns[0];
        String rawPolicy = columns[1];
        String password = columns[2];

        String[] rangeValues = range.split("-");
        String policy = rawPolicy.replace(":", "");

        return new PasswordData(
                Integer.parseInt(rangeValues[0]),
                Integer.parseInt(rangeValues[1]),
                policy,
                password
            );
    }

    private String loadInputData() throws Exception {
        InputStream stream = FileParser.class.getClassLoader().getResourceAsStream("exercise1-input.txt");
        return IOUtils.toString(stream, StandardCharsets.UTF_8);
    }
}
