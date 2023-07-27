package program.model.basic;


import program.model.Commands;
import program.model.Pet;

import java.time.LocalDate;

public class Hamster extends Pet {


    public Hamster(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }

    @Override
    public void addCommand(Commands command) {
        commandsSet.add(command);
    }


}

