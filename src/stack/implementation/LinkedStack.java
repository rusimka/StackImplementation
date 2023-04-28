package stack.implementation;

import stack.Node;
import stack.StackInterface;
import stack.exceptions.*;


public class LinkedStack<E> implements StackInterface<E> {

  private Node<E> top;
  private int size;
  private int maxSize;

  private final int MAX_SIZE_INTEGER = 2147483647;

  // creating an empty stack
  public LinkedStack(int maxSize) {
    this.maxSize = maxSize;
    this.top = null;
  }

  @Override
  public synchronized void push(E data) {
    if (isFull()) {
      throw new StackIsAlreadyFullException();
    }
    // to add the new Node on the top of the stack
    top = new Node<>(data, top);

    //    Node<E> newNode = new Node<>(data);
    //    newNode.next = top;
    //    top = newNode;
    size++;
  }

  @Override
  public synchronized E pop() {
    if (isEmpty()) {
      throw new StackIsAlreadyEmptyException();
    }
    E data = top.data;
    top = top.next;
    size--;
    return data;
  }

  @Override
  public synchronized E peek() {
    if (isEmpty()) {
      throw new StackIsAlreadyEmptyException();
    }
    return top.data;
  }

  @Override
  public synchronized void growSizeStack(int size) throws NotAllowedSize {
    if (size < 0) {
      throw new NegativeNumberException(size);
    }
    if (size > MAX_SIZE_INTEGER) {
      throw new NotAllowedSize(size);
    }
    if (maxSize + size < 0) {
      throw new IntegerOverflowException();
    }
    maxSize += size;
    System.out.println("maximum size of the stack: " + maxSize);
  }

  @Override
  public synchronized int getStackSize() {
    Node<E> current = top;
    while (current != null) {
      size++;
      current = current.next;
    }
    return size;
  }

  @Override
  public int getStackMaximumSize() {
    return maxSize;
  }

  @Override
  public synchronized boolean isFull() {
    return size == maxSize;
  }

  @Override
  public synchronized boolean isEmpty() {
    return top == null;
  }

  @Override
  public String toString() {
    String result = "";
    Node<E> current = top;
    while (current != null) {
      result = result + current.toString() + "\n";
      current = current.next;
    }

    return result;
  }
}
