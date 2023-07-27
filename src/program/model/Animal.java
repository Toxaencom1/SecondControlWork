package program.model;


import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Animal {
    protected static int currentId = 0;
    protected int id;
    protected String name;
    protected LocalDate dateOfBirth;
    protected ArrayList<Commands> commandsList;

    protected abstract void addCommand(Commands commands);

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

    public ArrayList<Commands> getCommandsList() {
        return commandsList;
    }

    public void setCommandsList(ArrayList<Commands> commandsList) {
        this.commandsList = commandsList;
    }


    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() +
                " id = " + id +
                " Name = '" + name + '\'' +
                " Birthday = " + dateOfBirth +
                " Commands List = " + commandsList;
    }
}
