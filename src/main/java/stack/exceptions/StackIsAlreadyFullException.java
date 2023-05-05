package stack.exceptions;

public class StackIsAlreadyFullException extends RuntimeException {
    public StackIsAlreadyFullException() {
        super("You cannot add elements into the stack, because the stack is already full");
    }

}
