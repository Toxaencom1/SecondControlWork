package program.view.commands;

import program.view.View;

public interface IActions {
    String description();
    void runCommand();
    View getView();
}
