package program.view;

import program.ScannerS;
import program.Validator;
import program.presenter.Presenter;
import program.view.menu.Menu;
import program.view.menu.SimpleMenu;

import java.util.Scanner;

public class ConsoleUi implements View {
    private Presenter presenter;
    private Validator validator;
    private Menu menu;
    private Scanner scanner;
    boolean flag;

    public ConsoleUi() {
        this.menu = new SimpleMenu(this);
        validator = new Validator();
        scanner = ScannerS.getScanner();
        flag = true;
    }

    @Override
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        System.out.println("Welcome Home User!\n(Emergency exit available, just type exit anywhere)");
        while (flag){
            menu.showMenu();
            System.out.print("Your Choice: ");
            menu.execute(validator.valMenuChoice(scanner.nextLine(), menu.getMenuListSize()));
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void exit() {
        presenter.exit();
    }

    @Override
    public void showCommands() {
        presenter.showCommands();
    }

    @Override
    public Menu getTypeMenu() {
        return menu;
    }

    @Override
    public void addAnimal() {
        presenter.addAnimal();

    }

    @Override
    public String params() {
        return validator.emergency_exit(ScannerS.getScanner().nextLine().trim());
    }

    @Override
    public int whichOne() {
        return validator.valMenuChoice(scanner.nextLine(), menu.getTypeLength());
    }

    @Override
    public void addCommandToAnimal() {
        presenter.addCommandToAnimal();
    }

    @Override
    public void deleteAnimal() {
        presenter.deleteAnimal();
    }

    @Override
    public void showAnimals() {
        presenter.showAnimals();
    }

    public Menu getMenu() {
        return menu;
    }

    @Override
    public int scan() {
        System.out.print("Your choice: ");
        String choice = scanner.nextLine();
        return validator.valInt(choice);
    }
}
