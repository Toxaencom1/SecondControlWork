package program;

public class ThereIsNoSuchCommand extends Exception {
    ThereIsNoSuchCommand(String message) {
        super(message);
    }
}
