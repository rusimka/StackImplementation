package stack.implementation;

import stack.StackInterface;
import stack.exceptions.StackIsAlreadyEmptyException;
import stack.exceptions.StackIsAlreadyFullException;

public class Stack<E> implements StackInterface<E> {

  private int maxSize;

  // 'top' is the index of the element that's on the top of the stack
  private int top;
  private  E[] stackArray;

  public Stack(int maxSize) {
    this.maxSize = maxSize;
    stackArray = (E[]) new Object[maxSize];
    top = -1;
  }


  @Override
  public synchronized void push(E element) {
    if (isFull()) {
      throw new StackIsAlreadyFullException();
    }
    top++;
    stackArray[top] = element;
  }

  @Override
  public synchronized E pop() {
    if (isEmpty()) {
      throw new StackIsAlreadyEmptyException();
    }
    E topValue = stackArray[top];
    top--;
    return topValue;
  }

  @Override
  public synchronized E peek() {
    if (isEmpty()) {
      throw new StackIsAlreadyEmptyException();
    }
    return stackArray[top];
  }

  @Override
  public synchronized void growSizeStack(int size) {
    maxSize += size;
    E[] newStackArray = (E[]) new Object[maxSize];
  }


  // function to get how many elements are added into the stack
  @Override
  public synchronized int getStackSize() {
    return stackArray.length;

  }

  @Override
  public int getStackMaximumSize() {
    return maxSize;
  }

  @Override
  public synchronized boolean isFull() {
    return top == maxSize - 1;
  }

  @Override
  public synchronized boolean isEmpty() {
    return top == -1;
  }

}
