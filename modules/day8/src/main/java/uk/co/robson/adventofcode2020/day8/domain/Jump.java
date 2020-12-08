package uk.co.robson.adventofcode2020.day8.domain;

public class Jump extends AbstractCommand {

    public Jump(int instruction) {
        super(instruction);
    }

    public Jump(String instruction) {
        super(instruction);
    }

    @Override
    public BootState execute(BootState state) {
        return new BootState(state.getPosition() + instruction, state.getAccumulator());
    }
}
