package program.model;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

public abstract class Pet extends Animal {

    public Pet(String name, LocalDate dateOfBirth) {
        this.id = ++currentId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.commandsSet = new HashSet<>(Arrays.asList(Commands.GO, Commands.STOP));

    }
}
