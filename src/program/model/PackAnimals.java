package program.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class PackAnimals extends Animal{

    public PackAnimals(String name, LocalDate dateOfBirth) {
        this.id = ++currentId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.commandsList = new ArrayList<>(Arrays.asList(Commands.FORWARD,Commands.STOP));
    }
}
