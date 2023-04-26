import stack.implementation.LinkedStack;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.

        LinkedStack stack = new LinkedStack(5);
        stack.push(1);
        stack.push(2);
    System.out.println(stack);
    //    stack.toString();
    System.out.println("After pop");
    stack.pop();
    System.out.println(stack);
    System.out.println("Peek the first element: " + stack.peek());
    }
}