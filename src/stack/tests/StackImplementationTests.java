package stack.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import stack.exceptions.NotAllowedSize;
import stack.implementation.LinkedStack;
import stack.implementation.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class StackImplementationTests {

  @Test
  public void pushPopTest() {
    LinkedStack stack = new LinkedStack(5);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals(3, stack.pop());
    //        assertEquals(4,stack.pop()); // FAILED, because the element on the top of the stack is
    // 3, not 4
    //
    //        stack.push(4);
    //        stack.push(5);
    //        stack.push(6); // StackIsAlreadyFullException will be throwned
    //        assertEquals(6,stack.pop());
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2})
  public void pushPopParametrizedTest(int number) {
    LinkedStack stack = new LinkedStack(5);
    stack.push(number);
    assertEquals(2,stack.pop());
  }

  @ParameterizedTest
  @CsvSource({
          "1, 2, 3",
  })
  void testPushAndPopParametrizedTest2(int a, int b, int c) {
    LinkedStack stack = new LinkedStack(3);
    // Push the values onto the stack
    stack.push(a);
    stack.push(b);
    stack.push(c);
    // Pop the values from the stack and check that they are correct
    assertEquals(c, stack.pop());
    assertEquals(b, stack.pop());
    assertEquals(a, stack.pop());
    // Check that the stack is now empty
    assertTrue(stack.isEmpty());
  }


  @Test
  public void peekTest() {
    LinkedStack stack = new LinkedStack(5);
    stack.push(1);
    assertEquals(1, stack.peek());
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void testPeekParametrized(int value) {
    LinkedStack stack = new LinkedStack(5);
    // Push the value onto the stack
    stack.push(value);
    // Peek at the top value and check that it is correct
    assertEquals(value, stack.peek());
    // Check that the stack size has not changed
    assertEquals(1, stack.getStackSize());
  }

  @Test
  public void testGrowSizeStack() throws NotAllowedSize {
    LinkedStack stack = new LinkedStack(5);
    stack.growSizeStack(2147483645);
    assertEquals(11, stack.getStackMaximumSize());
  }

  @Test
  public void testGetSizeStack() {
    LinkedStack stack = new LinkedStack(5);
    stack.push(1);
    assertEquals(1, stack.getStackSize());
  }

  @Test
  public void testArrayStackSize(){
    Stack stack = new Stack(5);
    stack.push(1);
    assertEquals(1,stack.getStackSize());
  }

  @Test
  public void testIsFull() {

    LinkedStack stack = new LinkedStack(5);
    stack.push(1);
    /* Test Case 1: Assertion that the stack is not full */
    assertFalse(stack.isFull()); // PASSED TEST

    /* Test Case 2: Assertion that the stack is full */
    //     assertTrue(stack.isFull()); // FAILED

    /* Test Case 3: Assertion that the stack is full when the stack is filled with all elements */
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    //            assertTrue(stack.isFull()); // PASSED

    /* Test Case 4: Assertion that the stack is not full when is filled with all elements*/
    //            assertFalse(stack.isFull()); // FAILED
  }

  @Test
  public void testIsEmpty() {
    LinkedStack stack = new LinkedStack(5);

    /* Test Case 1: When the stack is empty */
    assertTrue(stack.isEmpty()); // PASSED

    /* Test Case 2 - Assertion that the stack is not emtpy when the stack is actually empty*/
    //            assertFalse(stack.isEmpty()); // FAILED

    /* Test Case 3 - Assertion that the stack is empty, when the stack has one element */
    //            stack.push(1);
    //            assertTrue(stack.isEmpty()); // FAILED

    /* Test Case 4 - Assertion that the stack is not emtpy, when it has one element */
    //            assertFalse(stack.isEmpty()); // PASSED
  }
}
