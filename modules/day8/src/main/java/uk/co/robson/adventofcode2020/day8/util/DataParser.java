package uk.co.robson.adventofcode2020.day8.util;

import org.apache.commons.io.IOUtils;
import uk.co.robson.adventofcode2020.day8.domain.Acc;
import uk.co.robson.adventofcode2020.day8.domain.Command;
import uk.co.robson.adventofcode2020.day8.domain.Jump;
import uk.co.robson.adventofcode2020.day8.domain.Noop;

import javax.lang.model.type.UnknownTypeException;
import javax.swing.text.html.HTMLDocument;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    public List<Command> parseFile(String name) throws Exception {
        String[] rawLines = loadInputData(name).split("\n");
        return Arrays.stream(rawLines)
                .map(this::parseCommand)
                .collect(Collectors.toList());
    }

    private String loadInputData(String name) throws Exception {
        InputStream stream = DataParser.class.getClassLoader().getResourceAsStream(name);
        return IOUtils.toString(stream, StandardCharsets.UTF_8);
    }

    private Command parseCommand(String line) throws RuntimeException {
        String[] rawSplit = line.split(" ");
        String shortName = rawSplit[0];
        String instruction = rawSplit[1];

        switch(shortName) {
            case "jmp":
                return new Jump(instruction);
            case "acc":
                return new Acc(instruction);
            case "nop":
                return new Noop(instruction);
            default:
                throw new RuntimeException("Unknown command name: " + shortName);
        }
    }
}
