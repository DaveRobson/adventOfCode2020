package uk.co.robson.adventofcode2020.day7.domain;

import java.util.Map;

public class Rule {

    private String colour;
    private Map<String, Integer> contains;

    public Rule(String colour, Map<String, Integer> contains) {
        this.colour = colour;
        this.contains = contains;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Map<String, Integer> getContains() {
        return contains;
    }

    public void setContains(Map<String, Integer> contains) {
        this.contains = contains;
    }
}
