package program.model.basic;


import program.model.Commands;
import program.model.Pet;

import java.time.LocalDate;


public class Cat extends Pet {


    public Cat(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }

    @Override
    public void addCommand(Commands command) {
        commandsList.add(command);
    }


}
