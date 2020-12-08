package uk.co.robson.adventofcode2020.day7;

import uk.co.robson.adventofcode2020.day7.domain.Rule;
import uk.co.robson.adventofcode2020.day7.util.DataParser;
import uk.co.robson.adventofcode2020.day7.util.LuggageProcessor;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

public class Exercise2 {

    public static void main(String[] args) throws Exception {

        DataParser parser = new DataParser();
        List<String> rawLines = parser.parseFile("exercise-input.txt");
        LuggageProcessor processor = new LuggageProcessor();
        List<Rule> rules = processor.parseForRules(rawLines);
        Map<String, Rule> mappedRules = rules.stream()
                .collect(toMap(Rule::getColour, rule -> rule));

        int numberOfRequiredBags = processor.reqNumOfBags(mappedRules, "shinygold", 0);

        System.out.println("Number of required bags: " + numberOfRequiredBags);

    }
}
