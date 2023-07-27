package program.model.basic;


import program.model.Commands;
import program.model.Pet;

import java.time.LocalDate;

public class Dog extends Pet {


    public Dog(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }

    @Override
    public void addCommand(Commands command) {
        commandsSet.add(command);
    }

}
