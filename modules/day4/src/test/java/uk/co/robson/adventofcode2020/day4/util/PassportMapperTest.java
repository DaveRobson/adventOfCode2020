package uk.co.robson.adventofcode2020.day4.util;

import org.junit.jupiter.api.Test;
import uk.co.robson.adventofcode2020.day4.domain.Passport;

import static org.junit.jupiter.api.Assertions.*;

class PassportMapperTest {

    @Test
    public void shouldParseRow() {
        String testData = "eyr:2029 pid:157374862 byr:1991 ecl:amb hcl:#a97842 hgt:178cm";

        PassportMapper mapper = new PassportMapper();
        Passport passport = mapper.fromRaw(testData);
        assertEquals("2029", passport.getExpYear());
        assertEquals("157374862", passport.getId());
        assertEquals("1991", passport.getBirthYear());
        assertEquals("amb", passport.getEyeColour());
        assertEquals("#a97842", passport.getHairColour());
        assertEquals("178cm", passport.getHeight());
    }

}