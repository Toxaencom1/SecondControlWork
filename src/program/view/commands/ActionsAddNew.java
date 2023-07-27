package program.view.commands;

import program.view.View;

public class ActionsAddNew extends Actions {
    public ActionsAddNew(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Add new Animal";
    }

    @Override
    public void runCommand() {
        getView().addAnimal();
    }
}
