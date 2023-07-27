package program.model;

public class Counter implements AutoCloseable {
    private int value = 0;
    private boolean resourceClosed = false;

    public void add() throws IllegalStateException {
        if (resourceClosed) {
            throw new IllegalStateException("The counter was closed or used outside of a resource try.");
        } else {
            this.value+=1;
        }
    }

    public void close() {
        resourceClosed = true;
    }

    public int getValue() {
        return value;
    }
}