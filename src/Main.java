import stack.exceptions.NotAllowedSize;
import stack.implementation.LinkedStack;
import stack.implementation.NodeStack;
import stack.implementation.Stack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) throws NotAllowedSize {
    // Press Alt+Enter with your caret at the highlighted text to see how
    // IntelliJ IDEA suggests fixing it.

    //    LinkedStack stack = new LinkedStack(2147483645);
    //    stack.push(1);
    //    stack.push(2);
    //    System.out.println(stack);
    //    //    stack.toString();
    //    System.out.println("After pop");
    //    stack.pop();
    //    System.out.println(stack);
    //    System.out.println("Peek the first element: " + stack.peek());
    //    stack.growSizeStack(10);
    //    System.out.println("Maximum size stack is after growing is: " +
    // stack.getStackMaximumSize());
    //    System.out.println(stack.getStackSize());

    // testing the NodeStack implementation
    NodeStack nodeStack = new NodeStack(0);
    nodeStack.push(1);
    nodeStack.push(2);
    nodeStack.pop();
    nodeStack.grow(5);
    System.out.println("Number of elements in the stack: " + nodeStack.getStackSize());
  }
}
