package uk.co.robson.adventofcode2020.day4;

import uk.co.robson.adventofcode2020.day4.util.DataParser;
import uk.co.robson.adventofcode2020.day4.util.PassportMapper;
import uk.co.robson.adventofcode2020.day4.util.PassportValidator;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        List<String> lines = parser.parseFile("exercise-input.txt");
        PassportMapper mapper = new PassportMapper();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        long validPassports = lines.stream()
                .map(mapper::fromRaw)
                .filter(passport -> validator.validate(passport).isEmpty())
                .count();

        System.out.println("Number of valid passports: " + validPassports);

    }
}
