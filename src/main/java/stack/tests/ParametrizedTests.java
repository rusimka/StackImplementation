package stack.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stack.StackInterface;
import stack.implementation.LinkedStack;
import stack.implementation.Stack;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedTests {

  @ParameterizedTest
  @MethodSource("stackImplementations")
  public void testPushPop(StackInterface<Integer> stack) {
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.pop());
  }

  @ParameterizedTest
  @MethodSource("stackImplementations")
  public void testPeek(StackInterface<Integer> stack) {
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.peek());
  }

  @ParameterizedTest
  @MethodSource("stackImplementationTwo")
  public void testPeek(LinkedStack linkedStack){
    linkedStack.push(1);
    linkedStack.push(2);
    assertEquals(2,linkedStack.peek());
  }

  @ParameterizedTest
  @MethodSource("stackImplementationTwo")
  public void testPeek(){
    LinkedStack stack = new LinkedStack(5);
    stack.push(1);
    stack.push(2);
    assertEquals(2,stack.peek());
  }

  static Stream<StackInterface<Integer>> stackImplementations() {
    return Stream.of(new LinkedStack<>(5), new Stack<>(5));
  }

  static Stream<Arguments> stackImplementationTwo() {
    return Stream.of(Arguments.of(new LinkedStack<>(5)), Arguments.of(new Stack<>(5)));
  }
}
