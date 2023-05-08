package stack.tests;

import org.junit.jupiter.api.Test;

import stack.exceptions.*;
import stack.implementation.NodeStack;

import static org.junit.jupiter.api.Assertions.*;

public class NodeStackTests {

  @Test
  void pushTest()  {
    NodeStack<Integer> nodeStack = new NodeStack<>(5);
    nodeStack.push(1);
    assertTrue(nodeStack.top.getData() == 1);
  }

  @Test
  void testStackIsAlreadyFullException()  {
    NodeStack<Integer> nodeStack = new NodeStack<>(2);
    nodeStack.push(1);
    nodeStack.push(2);
    assertThrows(StackIsAlreadyFullException.class, () -> nodeStack.push(3));
  }

  @Test
  void testPop()  {
    NodeStack<Integer> nodeStack = new NodeStack<>(5);
    nodeStack.push(1);
    nodeStack.push(2);
    nodeStack.push(3);
    nodeStack.pop();
    assertTrue(nodeStack.top.getData() == 2);
  }

  @Test
  void testStackIsAlreadyEmptyException()  {
    NodeStack<Integer> nodeStack = new NodeStack<>(5);
    assertThrows(StackIsAlreadyEmptyException.class, () -> nodeStack.pop());
  }

  @Test
  void testPeek()  {
    NodeStack<Integer> nodeStack = new NodeStack<>(5);
    nodeStack.push(1);
    nodeStack.push(2);
//    assertTrue(nodeStack.top.getData() == 2);
    assertEquals(nodeStack.peek(),nodeStack.top.getData());
  }

  @Test
  void testPeekException() {
    NodeStack<Integer> nodeStack = new NodeStack<>(5);
    assertThrows(StackIsAlreadyEmptyException.class, () -> nodeStack.peek());
  }

  @Test
  public void testGrow() {
    NodeStack<Integer> stack = new NodeStack<>(3);
    stack.grow(2);
    assertEquals(5,stack.getStackMaximumSize());
  }

  @Test
  public void testGrowWithNegativeSize()  {
    NodeStack<Integer> stack = new NodeStack<>(3);
    assertThrows(NegativeNumberException.class, () -> stack.grow(-1));
  }

  @Test
  public void testGrowWithOverflow()  {
    NodeStack<Integer> stack = new NodeStack<>(3);
   assertThrows(IntegerOverflowException.class, () -> stack.grow(Integer.MAX_VALUE));
  }

  @Test
  public void testGetStackSize() {
    NodeStack<Integer> nodeStack = new NodeStack<>(5);
    nodeStack.push(1);
    assertEquals(1,nodeStack.getStackSize());
    nodeStack.push(2);
    assertEquals(nodeStack.top.getIndex(),nodeStack.getStackSize());
  }

  @Test
  public void isFullShouldReturnFalseWhenStackIsNotFull()  {
    NodeStack<Integer> stack = new NodeStack<>(5);
    stack.push(1);
    assertFalse(stack.isFull());
  }

  @Test
  public void isFullShouldReturnTrueWhenStackIsFull()  {
    NodeStack<Integer> stack = new NodeStack<>(2);
    stack.push(1);
    stack.push(2);
    assertTrue(stack.isFull());
  }

  @Test
  public void isEmptyShouldReturnTrueWhenStackIsEmpty()  {
    NodeStack<Integer> stack = new NodeStack<>(5);
    assertTrue(stack.isEmpty());
  }

  @Test
  public void isEmptyShouldReturnFalseWhenStackIsNotEmpty()  {
    NodeStack<Integer> stack = new NodeStack<>(5);
    stack.push(1);
    assertFalse(stack.isEmpty());
  }

  @Test
  void getStackMaximumSizeTest()  {
    NodeStack<Integer> stack = new NodeStack<>(10);
    assertEquals(10, stack.getStackMaximumSize());
  }
}
