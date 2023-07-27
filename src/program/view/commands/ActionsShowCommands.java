package program.view.commands;

import program.view.View;

public class ActionsShowCommands extends Actions {
    public ActionsShowCommands(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Show animal commands";
    }

    @Override
    public void runCommand() {
        getView().showCommands();
    }
}
