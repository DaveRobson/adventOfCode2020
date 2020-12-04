package uk.co.robson.adventofcode2020.day4.util;

import com.google.common.base.Stopwatch;
import uk.co.robson.adventofcode2020.day4.domain.Passport;

import java.util.List;
import java.util.function.Predicate;

public class CommonExercise {

    public static void execute(Predicate<Passport> predicate) throws Exception {
        DataParser parser = new DataParser();
        List<String> lines = parser.parseFile("exercise-input.txt");
        PassportMapper mapper = new PassportMapper();

        long validPassports = lines.stream()
                .map(mapper::fromRaw)
                .filter(predicate)
                .count();

        System.out.println("Number of valid passports: " + validPassports);
    }
}
