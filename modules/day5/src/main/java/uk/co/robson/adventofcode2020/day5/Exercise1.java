package uk.co.robson.adventofcode2020.day5;

import uk.co.robson.adventofcode2020.day5.util.DataParser;
import uk.co.robson.adventofcode2020.day5.util.SeatCalculator;

import java.util.List;
import java.util.Optional;

public class Exercise1 {
    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        List<String> bspList = parser.parseFile("exercise-input.txt");

        SeatCalculator calc = new SeatCalculator();
        Optional<Double> maxSeatId = calc.find(bspList);

        if(maxSeatId.isPresent()) {
            System.out.println("Highest seatId is: " + maxSeatId.get());
        } else {
            System.out.println("Didnt work mate!");
        }
    }
}
