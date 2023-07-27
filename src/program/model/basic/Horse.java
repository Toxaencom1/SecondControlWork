package program.model.basic;


import program.model.Commands;
import program.model.PackAnimals;

import java.time.LocalDate;

public class Horse extends PackAnimals {


    public Horse(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }

    @Override
    protected void addCommand(Commands command) {
        commandsSet.add(command);
    }
}
