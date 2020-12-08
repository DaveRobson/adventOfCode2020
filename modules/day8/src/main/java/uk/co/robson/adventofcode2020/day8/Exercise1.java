package uk.co.robson.adventofcode2020.day8;

import uk.co.robson.adventofcode2020.day8.domain.BootState;
import uk.co.robson.adventofcode2020.day8.domain.Command;
import uk.co.robson.adventofcode2020.day8.domain.GameConsole;
import uk.co.robson.adventofcode2020.day8.util.DataParser;

import java.util.List;

public class Exercise1 {

    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        List<Command> commands = parser.parseFile("exercise-input.txt");

        GameConsole console = new GameConsole(commands.toArray(new Command[]{}));
        BootState bootState = new BootState(0, 0);
        int visitedIndex = console.boot(bootState);

        System.out.println("Visited instruction: " + visitedIndex);
    }
}
