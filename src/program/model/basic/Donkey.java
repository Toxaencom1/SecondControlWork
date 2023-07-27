package program.model.basic;


import program.model.Commands;
import program.model.PackAnimals;

import java.time.LocalDate;


public class Donkey extends PackAnimals {


    public Donkey(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }

    @Override
    protected void addCommand(Commands command) {
        commandsList.add(command);
    }
}

