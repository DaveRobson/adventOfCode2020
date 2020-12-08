package uk.co.robson.adventofcode2020.day7.util;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import uk.co.robson.adventofcode2020.day7.domain.Rule;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LuggageProcessorTest {

    @Test
    public void shouldParseForRuleContaining2() {
        LuggageProcessor processor = new LuggageProcessor();
        Rule rule = processor.parseForRule("dim red bags contain 2 bright gold bags, 5 striped fuchsia bags.");
        assertEquals("dimred", rule.getColour());
        assertTrue(rule.getContains().containsKey("brightgold"));
        assertEquals(2, rule.getContains().get("brightgold"));
        assertTrue(rule.getContains().containsKey("stripedfuchsia"));
        assertEquals(5, rule.getContains().get("stripedfuchsia"));
    }

    @Test
    public void shouldParseForRuleContaining1() {
        LuggageProcessor processor = new LuggageProcessor();
        Rule rule = processor.parseForRule("wavy crimson bags contain 5 dull tomato bags.");
        assertEquals("wavycrimson", rule.getColour());
        assertTrue(rule.getContains().containsKey("dulltomato"));
        assertEquals(5, rule.getContains().get("dulltomato"));
    }

    @Test
    void shouldCalNumOfBags() {
        List<Rule> rules = new ArrayList<>();
        rules.add(new Rule("brightwhite", ImmutableMap.of("shinygold", 1)));
        rules.add(new Rule("lightred", ImmutableMap.of("brightwhite", 1, "mutedyellow", 2)));
        rules.add(new Rule("darkorange", ImmutableMap.of("brightwhite", 3, "mutedyellow", 4)));
        rules.add(new Rule("mutedyellow", ImmutableMap.of("shinygold", 2, "fadedblue", 9)));
        rules.add(new Rule("shinygold", ImmutableMap.of("darkolive", 1, "vibrantplum", 2)));
        rules.add(new Rule("darkolive", ImmutableMap.of("fadedblue", 3, "dottedblack", 4)));
        rules.add(new Rule("vibrantplum", ImmutableMap.of("fadedblue", 5, "dottedblack", 6)));
        rules.add(new Rule("fadedblue", null));
        rules.add(new Rule("dottedblack", null));

        LuggageProcessor processor = new LuggageProcessor();
        int numOfBags = processor.calNumOfBags(rules, "shinygold", new HashSet<>()).size();
        assertEquals(4, numOfBags);
    }
}