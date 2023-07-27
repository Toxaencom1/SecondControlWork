package program.view.menu;


import program.view.View;
import program.view.commands.*;

import java.util.ArrayList;

public class SimpleMenu implements Menu {
    private final ArrayList<IActions> menuList;
    private enum type {Dog,Cat,Hamster,Horse,Camel,Donkey}

    public SimpleMenu(View view) {
        this.menuList = new ArrayList<>();
        menuList.add(new ShowAnimals(view));
        menuList.add(new ActionsAddNew(view));
        menuList.add(new ActionsDeleteAnimal(view));
        menuList.add(new ActionsShowCommands(view));
        menuList.add(new ActionsAddCommand(view));
        menuList.add(new Exit(view));
    }

    public void showMenu() {
        int num = 1;
        System.out.println();
        for (IActions item : menuList) {
            System.out.println(num + " " + item.description());
            num += 1;
        }
    }
    public void showTypeMenu() {
        int num = 1;
        System.out.println();
        for (type value : type.values()) {
            System.out.println(num + " " + value);
            num += 1;
        }
    }

    @Override
    public void execute(int num) {
        IActions command = menuList.get(num - 1);
        command.runCommand();
    }

    @Override
    public int getMenuListSize() {
        return menuList.size();
    }
    public int getTypeLength() {
        return type.values().length;
    }
}
