package program.view.commands;

import program.view.View;

public class ActionsDeleteAnimal extends Actions {

    public ActionsDeleteAnimal(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Delete Animal";
    }

    @Override
    public void runCommand() {
        getView().deleteAnimal();
    }
}
