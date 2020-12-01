package uk.co.robson.adventofcode2020.day1;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        String[] lines = loadInputData().split("\n");
        System.out.println(calc(lines));


    }

    private static String loadInputData() throws Exception {
        InputStream stream = Exercise1.class.getClassLoader().getResourceAsStream("expense-input.txt");
        return IOUtils.toString(stream, StandardCharsets.UTF_8);
    }

    private static int calc(String[] lines) {
        for(int i = 0; i < lines.length ; i++) {
            for(int j = i + 1; j < lines.length; j++) {
                if(!lines[i].equals(lines[j])) {
                    int valuei = Integer.parseInt(lines[i]);
                    int valuej = Integer.parseInt(lines[j]);
                    if((valuei + valuej) == 2020) {
                        return valuei * valuej;
                    }
                }
            }
        }

        System.out.println("Oops didnt find anything");
        return 0;
    }

}
