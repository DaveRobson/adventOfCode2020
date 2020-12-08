package uk.co.robson.adventofcode2020.day7.util;

import uk.co.robson.adventofcode2020.day7.domain.Rule;

import java.util.*;
import java.util.stream.Collectors;

public class LuggageProcessor {

    public List<Rule> parseForRules(List<String> rawLines) {
        return rawLines.stream()
                .map(this::parseForRule)
                .collect(Collectors.toList());
    }

    public Set<Rule> calNumOfBags(List<Rule> rules, String colour, Set<Rule> acc) {
        if (!rules.isEmpty()) {
            List<Rule> outerColours = rules.stream()
                    .filter(rule -> containsColour(rule, colour))
                    .collect(Collectors.toList());
            if(!acc.containsAll(outerColours)) {
                acc.addAll(outerColours);
            }

            List<Rule> innerColours = outerColours.stream()
                    .flatMap(rule -> calNumOfBags(rules, rule.getColour(), acc).stream())
                    .collect(Collectors.toList());

            acc.addAll(innerColours);
        }
        return acc;
    }

    public int reqNumOfBags(Map<String, Rule> rules, String colour, int sum) {
        Rule bag = rules.get(colour);

        if(bag.getContains() != null) {
            int bagCount = bag.getContains().values().stream()
                .reduce(0, (current, acc) -> acc += current);

            int innerCount = bag.getContains().keySet().stream()
                    .map(key -> bag.getContains().get(key) * reqNumOfBags(rules, key, sum))
                    .reduce(0, (current, acc) -> acc += current);

            return bagCount + innerCount + sum;
        }

        return sum;

    }

    public Rule parseForRule(String rawLine) {
        String colour = rawLine.substring(0, rawLine.indexOf("bags"))
                .replace(" ", "");

        if(rawLine.contains("contain no other bags")) {
            return new Rule(colour, null);
        }


        String contains = rawLine.substring(rawLine.indexOf("contain") + 7);

        String[] rawRules;

        if(contains.contains(",")) {
            rawRules = contains.split(",");
        } else {
            rawRules = new String[]{contains};
        }

        return constructRule(rawRules, colour);
    }

    public Rule constructRule(String[] rawRules, String colour) {
        Map<String, Integer> contains = Arrays.stream(rawRules)
                .map(rawContains -> rawContains.replaceAll("bags|bag|\\.|\\s", ""))
                .collect(Collectors.toMap(this::keyMapper, this::valueMapper));

        return new Rule(colour, contains);
    }


    public String keyMapper(String line) {
        return line.substring(1);
    }

    public Integer valueMapper(String line) {
        return Integer.parseInt(line.substring(0, 1));
    }

    public static Boolean containsColour(Rule rule, String colour) {
        if(rule.getContains() == null) {
            return false;
        }

        return rule.getContains().keySet().stream()
                .anyMatch(colour::equals);
    }
}
