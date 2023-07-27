package program.view.commands;

import program.view.View;

public class ShowAnimals extends Actions {

    public ShowAnimals(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Show Animals list";
    }

    @Override
    public void runCommand() {
        getView().showAnimals();
    }
}
