package stack.exceptions;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(int size){
        super(String.format("The number %d  you entered is negative and it's not allowed",size));
}

}
