package stack.exceptions;

public class NotAllowedSize extends Throwable {
  public NotAllowedSize(int size) {
    super(String.format("The size you entered %d is not allowed", size));
  }
}
