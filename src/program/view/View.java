package program.view;

import program.presenter.Presenter;
import program.view.menu.Menu;

public interface View {
    void setPresenter(Presenter presenter);
    void setFlag(boolean flag);
    void start();
    void print(String text);
    void exit();
    void showCommands();
    Menu getTypeMenu();
    Menu getMenu();
    void addAnimal();
    String params();
    int whichOne();

    void addCommandToAnimal();

    void deleteAnimal();

    void showAnimals();

    int scan();
}
