package program.view.commands;


import program.view.View;

public class Exit extends Actions {
    public Exit(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Exit";
    }

    @Override
    public void runCommand() {
        getView().exit();
    }
}
