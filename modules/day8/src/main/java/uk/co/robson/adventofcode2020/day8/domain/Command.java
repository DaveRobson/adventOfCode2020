package uk.co.robson.adventofcode2020.day8.domain;

public interface Command {
    BootState execute(BootState state);

    int getInstruction();
}
