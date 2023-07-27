package program.model;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

public abstract class PackAnimals extends Animal{

    public PackAnimals(String name, LocalDate dateOfBirth) {
        this.id = ++currentId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.commandsSet = new HashSet<>(Arrays.asList(Commands.FORWARD,Commands.STOP));
    }
}
