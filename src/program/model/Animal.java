package program.model;


import java.time.LocalDate;
import java.util.HashSet;

public abstract class Animal {
    protected static int currentId = 0;
    protected int id;
    protected String name;
    protected LocalDate dateOfBirth;
    protected HashSet<Commands> commandsSet;


    protected void addCommand(Commands command) {
        commandsSet.add(command);
    }
    protected void removeCommand(Commands command) {
        commandsSet.remove(command);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public HashSet<Commands> getCommandsSet() {
        return commandsSet;
    }

    public void setCommandsSet(HashSet<Commands> commandsSet) {
        this.commandsSet = commandsSet;
    }


    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() +
                " id = " + id +
                " Name = '" + name + '\'' +
                " Birthday = " + dateOfBirth +
                " Commands List = " + commandsSet;
    }
}
