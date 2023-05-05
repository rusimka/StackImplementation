package stack.exceptions;

public class MaximumSizeSmallerOrEqualToZeroException extends RuntimeException{
    public MaximumSizeSmallerOrEqualToZeroException(){
            super("The maximum size should be 1");
        }
}
