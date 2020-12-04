package uk.co.robson.adventofcode2020.day4.util;

import com.google.common.collect.Maps;
import uk.co.robson.adventofcode2020.day4.domain.Passport;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;

public class PassportMapper {

    public static final String ITEM_DELIMITER = " ";
    public static final String KEY_VALUE_DELIMITER = ":";

    public Passport fromRaw(String rawLine) {
        Passport passport = new Passport();
        Map<String, Consumer<String>> consumerStore = consumerStore(passport);
        String[] items = rawLine.split(ITEM_DELIMITER);
        Arrays.stream(items)
                .forEach(item -> parseAndSet(item, consumerStore));
        return passport;
    }

    public void parseAndSet(String row, Map<String, Consumer<String>> consumerStore) {
        String[] keyValue = row.split(KEY_VALUE_DELIMITER);
        String key = keyValue[0];
        String value = keyValue[1];
        Consumer<String> consumer = consumerStore.get(key);
        consumer.accept(value);
    }

    public Map<String, Consumer<String>> consumerStore(Passport passport) {
        Map<String, Consumer<String>> consumers = Maps.newHashMap();
        consumers.put("byr", passport::setBirthYear);
        consumers.put("iyr", passport::setIssueYear);
        consumers.put("eyr", passport::setExpYear);
        consumers.put("hgt", passport::setHeight);
        consumers.put("hcl", passport::setHairColour);
        consumers.put("ecl", passport::setEyeColour);
        consumers.put("pid", passport::setId);
        consumers.put("cid", passport::setCountryId);
        return consumers;
    }

}
