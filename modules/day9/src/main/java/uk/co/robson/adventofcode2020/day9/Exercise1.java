package uk.co.robson.adventofcode2020.day9;

import uk.co.robson.adventofcode2020.day9.util.DataParser;

import java.util.List;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        List<Long> values = parser.parseFile("exercise-input.txt");

        for(int i = 25; i < values.size(); i++) {
            if(!Exercise1.searchPrevious25(values, i)) {
                System.out.println("Couldn't find a sum pair for: " + values.get(i));
                break;
            }
        }
    }

    private static Boolean searchPrevious25(List<Long> values, int currentIndex) {
        int start = currentIndex - 25;
        Long currentValue = values.get(currentIndex);
        for(int i = start; i < currentIndex; i++) {
            Long firstValue = values.get(i);
            for(int j = i + 1; j < currentIndex; j++) {
                Long secondValue = values.get(j);

                if(currentValue == (firstValue + secondValue)) {
                    return true;
                }
            }
        }

        return false;
    }
}
