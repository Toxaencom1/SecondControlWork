package program;

import program.model.Counter;
import program.model.SimpleService;
import program.presenter.Presenter;
import program.view.ConsoleUi;
import program.view.View;

public class Main {
    public static void main(String[] args) {
        try (Counter counter = new Counter()){
            SimpleService service = new SimpleService(counter);
            View view = new ConsoleUi();
            new Presenter(view,service);
            view.start();
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}