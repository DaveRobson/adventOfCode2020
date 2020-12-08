package uk.co.robson.adventofcode2020.day8.domain;

public class Noop extends AbstractCommand {

    public Noop(int instruction) {
        super(instruction);
    }

    public Noop(String instruction) {
        super(instruction);
    }

    @Override
    public BootState execute(BootState state) {
        return new BootState(state.getPosition() + 1, state.getAccumulator());
    }
}
