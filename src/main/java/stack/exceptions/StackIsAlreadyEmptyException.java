package stack.exceptions;

public class StackIsAlreadyEmptyException extends RuntimeException {
    public StackIsAlreadyEmptyException() {
        super("Stack is empty");
    }
}
