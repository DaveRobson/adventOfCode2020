package uk.co.robson.adventofcode2020.day4.util;

import org.junit.jupiter.api.Test;
import uk.co.robson.adventofcode2020.day4.domain.Passport;

import static org.junit.jupiter.api.Assertions.*;

class PassportValidatorTest {

    @Test
    public void isValid() {
        Passport passport = new Passport();
        passport.setId("087499704");
        passport.setHeight("74in");
        passport.setEyeColour("grn");
        passport.setIssueYear("2012");
        passport.setExpYear("2030");
        passport.setBirthYear("1980");
        passport.setHairColour("#623a2f");

        PassportValidator validator = new PassportValidator();
        assertTrue(validator.isValid(passport));
    }

    @Test
    public void isValidIssueBoundary() {
        Passport passport = new Passport();
        passport.setId("093154719");
        passport.setHeight("158cm");
        passport.setEyeColour("blu");
        passport.setIssueYear("2010");
        passport.setExpYear("2021");
        passport.setBirthYear("1944");
        passport.setHairColour("#b6652a");

        PassportValidator validator = new PassportValidator();
        assertTrue(validator.isValid(passport));
    }

    @Test
    public void isNotValid() {
        Passport passport = new Passport();
        passport.setId("186cm");
        passport.setCountryId("100");
        passport.setHeight("170");
        passport.setEyeColour("amb");
        passport.setIssueYear("2018");
        passport.setExpYear("1972");
        passport.setBirthYear("1926");
        passport.setHairColour("#18171d");

        PassportValidator validator = new PassportValidator();
        assertFalse(validator.isValid(passport));
    }

}