package uk.co.robson.adventofcode2020.day2;

import uk.co.robson.adventofcode2020.day2.domain.PasswordData;
import uk.co.robson.adventofcode2020.day2.util.FileParser;

import java.util.List;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        FileParser parser = new FileParser();
        List<PasswordData> data = parser.parseFile();

        long count = data.stream()
                .filter(Exercise2::validPassword)
                .count();

        System.out.println(count);
    }

    private static Boolean validPassword(PasswordData passwordData) {
        int startIndex = passwordData.getStartRange()  - 1;
        int endIndex = passwordData.getEndRange() - 1;
        String policy = passwordData.getPolicy();

        String[] letters = passwordData.getValue().split("");

        if(letters[startIndex].equals(letters[endIndex])) {
            return false;
        } else {
            return policy.equalsIgnoreCase(letters[startIndex]) || policy.equalsIgnoreCase(letters[endIndex]);
        }
    }
}
