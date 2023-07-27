package program;

import program.model.SimpleService;
import program.presenter.Presenter;
import program.view.ConsoleUi;
import program.view.View;

public class Main {
    public static void main(String[] args) {
        SimpleService service = new SimpleService();
        View view = new ConsoleUi();
        new Presenter(view,service);
        view.start();
    }
}