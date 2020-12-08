package uk.co.robson.adventofcode2020.day8.domain;

import uk.co.robson.adventofcode2020.day8.domain.Command;

public abstract class AbstractCommand implements Command {

    protected int instruction;

    public AbstractCommand(String instruction) {
        this.instruction = Integer.parseInt(instruction);
    }

    public AbstractCommand(int instruction) {
        this.instruction = instruction;
    }

    public int getInstruction() {
        return instruction;
    }

    public void setInstruction(int instruction) {
        this.instruction = instruction;
    }
}
