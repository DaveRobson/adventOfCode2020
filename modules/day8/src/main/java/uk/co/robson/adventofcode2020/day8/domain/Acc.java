package uk.co.robson.adventofcode2020.day8.domain;

public class Acc extends AbstractCommand {
    public Acc(String instruction) {
        super(instruction);
    }

    public Acc(int instruction) {
        super(instruction);
    }

    @Override
    public BootState execute(BootState state) {
        return new BootState(state.getPosition() + 1, state.getAccumulator() + instruction);
    }
}
