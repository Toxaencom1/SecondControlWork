package program.model;

import java.util.ArrayList;

public interface Service {
    ArrayList<Animal> animalList = new ArrayList<>();
    boolean addAnimal(int choice, String name, String dayOfBirth, String commands);
    ArrayList<Animal> getAnimalList();

    String showCommands(int choice);

    String addCommandToAnimal(int choice, String command);

    String deleteAnimal(int choice);

    String animalListToString();
}
