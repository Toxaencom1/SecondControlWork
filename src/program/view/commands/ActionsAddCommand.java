package program.view.commands;

import program.view.View;

public class ActionsAddCommand extends Actions {


    public ActionsAddCommand(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Teach the animal new commands";
    }

    @Override
    public void runCommand() {
        getView().addCommandToAnimal();
    }
}
