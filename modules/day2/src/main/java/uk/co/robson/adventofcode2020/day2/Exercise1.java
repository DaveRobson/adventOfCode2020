package uk.co.robson.adventofcode2020.day2;

import uk.co.robson.adventofcode2020.day2.domain.PasswordData;
import uk.co.robson.adventofcode2020.day2.util.FileParser;

import java.util.Arrays;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        FileParser parser = new FileParser();
        List<PasswordData> data = parser.parseFile();

        long count = data.stream()
                .filter(Exercise1::validPassword)
                .count();

        System.out.println(count);
    }

    private static Boolean validPassword(PasswordData passwordData) {
        int startRange = passwordData.getStartRange();
        int endRange = passwordData.getEndRange();
        String policy = passwordData.getPolicy();

        long occurs = Arrays.stream(passwordData.getValue().split(""))
                .filter(l -> l.equalsIgnoreCase(policy))
                .count();

        return occurs >= startRange && occurs <= endRange;
    }
}
