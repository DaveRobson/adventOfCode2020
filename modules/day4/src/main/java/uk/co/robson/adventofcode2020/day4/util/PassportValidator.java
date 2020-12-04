package uk.co.robson.adventofcode2020.day4.util;

import com.google.common.collect.ImmutableList;
import uk.co.robson.adventofcode2020.day4.domain.Passport;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class PassportValidator {

    public Boolean isValid(Passport passport) {
        return  isNotEmpty(passport) &&
                validate(passport::getBirthYear, this::birthYear) &&
                validate(passport::getIssueYear, this::issueYear) &&
                validate(passport::getExpYear, this::expYear) &&
                validate(passport::getHeight, this::height) &&
                validate(passport::getEyeColour, this::eyeColour) &&
                validate(passport::getHairColour, this::hairColour) &&
                validate(passport::getId, this::pid);
    }

    public Boolean isNotEmpty(Passport passport) {
        return !isValueEmpty(passport.getBirthYear()) &&
                !isValueEmpty(passport.getIssueYear()) &&
                !isValueEmpty(passport.getExpYear()) &&
                !isValueEmpty(passport.getHeight()) &&
                !isValueEmpty(passport.getEyeColour()) &&
                !isValueEmpty(passport.getHairColour()) &&
                !isValueEmpty(passport.getId());
    }

    public Boolean validate(Supplier<String> getter, Function<String, Boolean> vFunc) {
        return vFunc.apply(getter.get());
    }

    public Boolean isValueEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public Boolean birthYear(String value) {
        int year = Integer.parseInt(value);
        return year >= 1920 && year <= 2002;
    }

    public Boolean issueYear(String value) {
        int year = Integer.parseInt(value);
        return year >= 2010 && year <= 2020;
    }

    public Boolean expYear(String value) {
        int year = Integer.parseInt(value);
        return year >= 2020 && year <= 2030;
    }

    public Boolean height(String value) {
        if(value.contains("cm") || value.contains("in")) {
            String unit = value.substring(value.length() - 2);
            String data = value.substring(0, value.length() - unit.length());
            int measure = Integer.parseInt(data);

            if(unit.equals("cm")) {
                return measure >= 150 && measure <= 193;
            } else {
                return measure >= 59 && measure <= 76;
            }
        } else {
            return false;
        }
    }

    public Boolean hairColour(String value) {
        return Pattern.matches("^#[a-f0-9]{6}$", value);
    }

    public Boolean eyeColour(String value) {
        List<String> colours = ImmutableList.of(
                "amb", "blu", "brn", "gry", "grn", "hzl", "oth"
        );
        return colours.contains(value);
    }

    public Boolean pid(String value) {
        return Pattern.matches("^[0-9]{9}$", value);
    }

}
