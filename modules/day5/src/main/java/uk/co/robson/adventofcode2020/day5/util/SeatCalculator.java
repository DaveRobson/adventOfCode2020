package uk.co.robson.adventofcode2020.day5.util;

import java.util.List;
import java.util.Optional;

public class SeatCalculator {

    public Optional<Double> find(List<String> bspList) {
        return bspList.stream()
                .map(this::seatId)
                .max(Double::compareTo);
    }

    public double walkBsp(String bsp, int index, double lowerBound, double upperBound) {
        char letter = bsp.charAt(index);
        Boolean lowerHalf = lowerHalf(letter);
        double half = (upperBound - lowerBound) * 0.5;
        double upper;
        double lower;

        if(half == 1 || half == 0.5) {
            return lowerHalf ? lowerBound : upperBound;
        }

        if(lowerHalf) {
            lower = lowerBound;
            upper = upperBound - Math.ceil(half);

        } else {
            lower = lowerBound + Math.ceil(half);
            upper = upperBound;
        }

        return walkBsp(bsp, index + 1, lower, upper);
    }

    public String rowBsp(String bsp) {
        return bsp.substring(0, 7);
    }

    public String colBsp(String bsp) {
        return bsp.substring(7);
    }

    public double seatId(String bsp) {
        String rowBsp = rowBsp(bsp);
        String colBsp = colBsp(bsp);

        double rowNum = walkBsp(rowBsp, 0, 0, 127);
        double colNum = walkBsp(colBsp, 0, 0, 7);
        return (rowNum * 8) + colNum;
    }

    public Boolean lowerHalf(char letter) {
        return letter == 'F' || letter == 'L';
    }
}
