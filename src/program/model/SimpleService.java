package program.model;


import program.ThereIsNoSuchCommand;
import program.model.basic.*;
import program.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class SimpleService implements Service {
    private Validator validator = new Validator();
    private Counter counter;

    private ArrayList<Animal> animalList = new ArrayList<>(Arrays.asList(
            new Dog("Rex", LocalDate.of(2015, 1, 15)),
            new Cat("Vasil", LocalDate.of(2018, 3, 8)),
            new Hamster("Tigur", LocalDate.of(2022, 5, 30)),
            new Horse("Ginger", LocalDate.of(2000, 8, 22)),
            new Camel("Sahara", LocalDate.of(1987, 11, 10)),
            new Donkey("Ia", LocalDate.of(2010, 12, 27))));

    public SimpleService(Counter counter) {
        this.counter = counter;
    }

    public boolean addAnimal(int choice, String name, String dayOfBirth, String commands) {
        try {
            validator.validateCommandsString(commands);
        } catch (ThereIsNoSuchCommand e) {
            System.err.println("Error while entering commands for animal! Repeat add new animal: ");
            return false;
        }
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date;
        try {
            date = LocalDate.parse(dayOfBirth, dateFormatter);
            counter.add();
            System.out.println("System message: Counter = " + counter.getValue());
            switch (choice) {
                case 1 -> {
                    Dog dog = new Dog(name, date);
                    animalList.add(dog);
                    addToCommandsList(dog, commands);
                    return true;
                }
                case 2 -> {
                    Cat Cat = new Cat(name, date);
                    animalList.add(Cat);
                    addToCommandsList(Cat, commands);
                    return true;
                }
                case 3 -> {
                    Hamster Hamster = new Hamster(name, date);
                    animalList.add(Hamster);
                    addToCommandsList(Hamster, commands);
                    return true;
                }
                case 4 -> {
                    Horse horse = new Horse(name, date);
                    animalList.add(horse);
                    addToCommandsList(horse, commands);
                    return true;
                }
                case 5 -> {
                    Camel camel = new Camel(name, date);
                    animalList.add(camel);
                    addToCommandsList(camel, commands);
                    return true;
                }
                case 6 -> {
                    Donkey donkey = new Donkey(name, date);
                    animalList.add(donkey);
                    addToCommandsList(donkey, commands);
                    return true;
                }
            }

        } catch (DateTimeParseException e) {
            System.err.println("Date conversion error: " + e.getMessage());
            return false;
        }
        return false;
    }

    @Override
    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    @Override
    public String showCommands(int choice) {
        StringBuilder sb = new StringBuilder();
        for (Animal animal :
                animalList) {
            if (animal.getId() == choice) {
                for (Commands commands :
                        animal.getCommandsSet()) {
                    sb.append(commands).append(" ");
                }
                return "Commands list: " + sb;
            }
        }
        return "Can`t find animal with this id";
    }

    @Override
    public String addCommandToAnimal(int choice, String command) {
        for (Animal animal :
                animalList) {
            if (animal.getId() == choice) {
                addToCommandsList(animal,command);
                return "Command added";
            }
        }
        return "Can`t find animal with this id";
    }

    private void addToCommandsList(Animal animal, String command) {
        try {
            validator.validateCommandsString(command);
        } catch (ThereIsNoSuchCommand e) {
            System.err.println("Error while entering commands for animal! Aborted");
        }
        ArrayList<String> temp = new ArrayList<>(Arrays.asList(command.trim().split(";")));
        for (String str :
                temp) {
            str = str.trim().toUpperCase();
            if (str.startsWith("DEL:")){
                str = str.replace("DEL:","").trim();
                animal.removeCommand(Commands.valueOf(str));
            } else {
                animal.addCommand(Commands.valueOf(str));
            }
        }
    }

    @Override
    public String deleteAnimal(int choice) {
        for (int i = 0; i < animalList.size(); i++) {
            if (animalList.get(i).id == choice) {
                animalList.remove(i);
                return "Successfully deleted";
            }
        }
        return "Can`t find animal with this id";
    }

    @Override
    public String animalListToString() {
        StringBuilder sb = new StringBuilder();
        for (Animal an :
                getAnimalList()) {
            sb.append("id = '").append(an.getId()).append("' ").append(an.getClass().getSimpleName()).append(" ").append(" Name = '").
                    append(an.getName()).append("' Birthday = ").append(an.getDateOfBirth()).append("\n");
        }

        return sb.toString();
    }
}
