package uk.co.robson.adventofcode2020.day4;

import com.google.common.base.Stopwatch;
import uk.co.robson.adventofcode2020.day4.util.CommonExercise;
import uk.co.robson.adventofcode2020.day4.util.PassportValidator;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        PassportValidator validator = new PassportValidator();
        CommonExercise.execute(validator::isNotEmpty);
        System.out.println("Execution time: " + stopwatch);
    }
}
