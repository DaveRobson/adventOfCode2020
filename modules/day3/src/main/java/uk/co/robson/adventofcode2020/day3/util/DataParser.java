package uk.co.robson.adventofcode2020.day3.util;



import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class DataParser {

    public int[][] parseFile(String name) throws Exception {
        String[] lines = loadInputData(name).split("\n");
        int columnTotal = lines[0].split("").length;

        int[][] course = new int[lines.length][columnTotal];

        for(int i = 0; i < lines.length; i++) {
            String[] columns = lines[i].split("");
            for (int j = 0; j < columns.length; j++) {
                course[i][j] = columns[j].equals(".") ? 0 : 1;
            }
        }
        return course;
    }


    private String loadInputData(String name) throws Exception {
        InputStream stream = DataParser.class.getClassLoader().getResourceAsStream(name);
        return IOUtils.toString(stream, StandardCharsets.UTF_8);
    }
}
