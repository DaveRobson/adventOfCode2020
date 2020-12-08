package uk.co.robson.adventofcode2020.day7;

import uk.co.robson.adventofcode2020.day7.domain.Rule;
import uk.co.robson.adventofcode2020.day7.util.DataParser;
import uk.co.robson.adventofcode2020.day7.util.LuggageProcessor;

import java.util.HashSet;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        List<String> rawLines = parser.parseFile("exercise-input.txt");
        LuggageProcessor processor = new LuggageProcessor();
        List<Rule> rules = processor.parseForRules(rawLines);
        int numOfBags = processor.calNumOfBags(rules, "shinygold", new HashSet<>()).size();

        System.out.println("Number of outer bags: " + numOfBags);
    }
}
