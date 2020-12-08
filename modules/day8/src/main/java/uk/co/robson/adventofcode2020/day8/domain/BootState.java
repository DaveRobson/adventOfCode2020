package uk.co.robson.adventofcode2020.day8.domain;

public class BootState {

    private final int position;
    private final int accumulator;

    public BootState(int position, int accumulator) {
        this.position = position;
        this.accumulator = accumulator;
    }

    public BootState(BootState console) {
        this.position = console.getPosition();
        this.accumulator = console.getAccumulator();
    }

    public int getPosition() {
        return position;
    }

    public int getAccumulator() {
        return accumulator;
    }
}
