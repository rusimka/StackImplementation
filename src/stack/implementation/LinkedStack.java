package stack.implementation;

import stack.Node;
import stack.StackInterface;
import stack.exceptions.StackIsAlreadyEmptyException;
import stack.exceptions.StackIsAlreadyFullException;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements StackInterface<E> {

  private Node<E> top;
  private int size;
  private int maxSize;

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
    top = new Node<>(data,top);

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
    if(top == null){
      throw new NoSuchElementException();
    }
    return top.data;
  }

  @Override
  public void growSizeStack(int size) {}

  @Override
  public int getStackSize() {
    return 0;
  }

  @Override
  public int getStackMaximumSize() {
    return 0;
  }

  @Override
  public boolean isFull() {
    return size == maxSize;
  }

  @Override
  public synchronized boolean isEmpty() {
    return top == null;
  }

  @Override
  public String toString() {
    String result = "";
    Node current = top;
    while (current != null) {
      result = result + current.toString() + "\n";
      current = current.next;
    }

    return result;
  }
}
