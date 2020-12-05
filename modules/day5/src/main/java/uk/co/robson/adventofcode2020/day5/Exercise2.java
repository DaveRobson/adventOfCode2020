package uk.co.robson.adventofcode2020.day5;

import uk.co.robson.adventofcode2020.day5.util.DataParser;
import uk.co.robson.adventofcode2020.day5.util.SeatCalculator;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        List<String> bspList = parser.parseFile("exercise-input.txt");

        SeatCalculator calc = new SeatCalculator();
        List<Double> seats = bspList.stream()
                .map(calc::seatId)
                .sorted(Double::compareTo)
                .collect(Collectors.toList());

        for(int i = 1; i < seats.size(); i++) {
            if((seats.get(i) - seats.get(i - 1)) != 1) {
                System.out.println("SeatId: " + (seats.get(i) - 1));
            }
        }
    }
}
