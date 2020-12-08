package uk.co.robson.adventofcode2020.day8.domain;

import java.util.ArrayList;
import java.util.List;

public class GameConsole {
    private Command[] bootCommands;
    private final List<Integer> visitedIndex;

    public GameConsole(Command[] bootCommands) {
        this.bootCommands = bootCommands;
        this.visitedIndex = new ArrayList<>();
    }

    public int boot(BootState state) {
        if(visitedIndex.contains(state.getPosition())) {
            return state.getPosition();
        }

        visitedIndex.add(state.getPosition());
        BootState newState = bootCommands[state.getPosition()].execute(state);
        return boot(newState);
    }

    public int boot2(BootState state) {
        if(state.getPosition() == bootCommands.length - 1) {
            return state.getAccumulator();
        }

        visitedIndex.add(state.getPosition());
        BootState newState = bootCommands[state.getPosition()].execute(state);
        return boot2(newState);
    }

    public Command[] getBootCommands() {
        return bootCommands;
    }

    public void setBootCommands(Command[] bootCommands) {
        this.bootCommands = bootCommands;
    }


}
