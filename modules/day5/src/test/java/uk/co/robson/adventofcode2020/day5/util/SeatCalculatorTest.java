package uk.co.robson.adventofcode2020.day5.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeatCalculatorTest {

    @Test
    public void shouldWalkBsp70() {
        SeatCalculator calc = new SeatCalculator();
        double result = calc.walkBsp("BFFFBBF", 0 , 0, 127);
        assertEquals(70, result);
    }

    @Test
    public void shouldWalkBsp14() {
        SeatCalculator calc = new SeatCalculator();
        double result = calc.walkBsp("FFFBBBF", 0 , 0, 127);
        assertEquals(14, result);
    }

    @Test
    public void shouldWalkBsp5() {
        SeatCalculator calc = new SeatCalculator();
        double result = calc.walkBsp("RLR", 0 , 0, 7);
        assertEquals(5, result);
    }

    @Test
    public void shouldWalkBsp7() {
        SeatCalculator calc = new SeatCalculator();
        double result = calc.walkBsp("RRR", 0 , 0, 7);
        assertEquals(7, result);
    }

    @Test
    public void shouldParseRow() {
        SeatCalculator calc = new SeatCalculator();
        String row = calc.rowBsp("BFFFBBFRRR");
        assertEquals("BFFFBBF", row);
    }

    @Test
    public void shouldParseCol() {
        SeatCalculator calc = new SeatCalculator();
        String col = calc.colBsp("BFFFBBFRRR");
        assertEquals("RRR", col);
    }

    @Test
    public void shouldGetSeatId357() {
        SeatCalculator calc = new SeatCalculator();
        double seatId = calc.seatId("FBFBBFFRLR");
        assertEquals(357, seatId);
    }

    @Test
    public void shouldGetSeatId567() {
        SeatCalculator calc = new SeatCalculator();
        double seatId = calc.seatId("BFFFBBFRRR");
        assertEquals(567, seatId);
    }

    @Test
    public void shouldGetSeatId820() {
        SeatCalculator calc = new SeatCalculator();
        double seatId = calc.seatId("BBFFBBFRLL");
        assertEquals(820, seatId);
    }

    @Test
    public void shouldGetSeatId119() {
        SeatCalculator calc = new SeatCalculator();
        double seatId = calc.seatId("FFFBBBFRRR");
        assertEquals(119, seatId);
    }

}