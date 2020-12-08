package uk.co.robson.adventofcode2020.day8;

import uk.co.robson.adventofcode2020.day8.domain.*;
import uk.co.robson.adventofcode2020.day8.util.DataParser;

import java.util.List;

public class Exercise2 {

    public static void main(String[] args) throws Exception {
        DataParser parser = new DataParser();
        List<Command> commands = parser.parseFile("exercise-input.txt");

        int acc = 0;

        for(int i = 0; i < commands.size(); i++) {
            try {
                Command[] modified = commands.toArray(new Command[]{});
                if(modified[i] instanceof Jump) {
                    modified[i] = new Noop(modified[i].getInstruction());
                    GameConsole console = new GameConsole(modified);
                    acc = console.boot2(new BootState(0, 0));
                    break;
                }

                if(modified[i] instanceof Noop) {
                    modified[i] = new Jump(modified[i].getInstruction());
                    GameConsole console = new GameConsole(modified);
                    acc = console.boot2(new BootState(0, 0));
                    break;
                }
            } catch (IndexOutOfBoundsException | StackOverflowError e) {
                System.out.println("This one wasnt the one");
            }

        }

        System.out.println("Visited instruction: " + acc);
    }
}
