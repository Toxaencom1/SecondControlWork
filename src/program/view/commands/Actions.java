package program.view.commands;


import program.view.View;

public abstract class Actions implements IActions {
    private View view;

    public Actions(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}
