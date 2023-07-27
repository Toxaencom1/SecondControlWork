package program.model.basic;


import program.model.Commands;
import program.model.PackAnimals;

import java.time.LocalDate;


public class Camel extends PackAnimals {


    public Camel(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
    }

    @Override
    protected void addCommand(Commands command) {
        commandsList.add(command);
    }


}


