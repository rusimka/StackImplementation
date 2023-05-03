package stack.implementation;

import stack.Node;
import stack.Stack;
import stack.exceptions.*;

import java.util.NoSuchElementException;

public class NodeStack<E> implements Stack<E> {

  private Node<E> top;
  private int maxSize;

  public NodeStack(int maxSize) throws NotAllowedSize {
    if (maxSize < 0) {
      throw new NegativeNumberException(maxSize);
    }
    if (maxSize >= Integer.MAX_VALUE) {
      throw new IntegerOverflowException();
    }

    this.top = null;
    this.maxSize = maxSize;
  }

  @Override
  public synchronized void push(E element) {
    if (isFull()) {
      throw new StackIsAlreadyFullException();
    }
    top = new Node<>(element, top);
  }

  @Override
  public synchronized E pop() {
    if (isEmpty()) {
      throw new StackIsAlreadyEmptyException();
    }
    E data = top.getData();
    top = top.getNext();
    return data;
  }

  @Override
  public synchronized E peek() {
    if (isEmpty()) {
      throw new StackIsAlreadyFullException();
    }
    return top.getData();
  }

  @Override
  public void grow(int size) throws NotAllowedSize {
    if(size<0){
      throw new NegativeNumberException(size);
    }
    if(maxSize + size < 0 ){
      throw new IntegerOverflowException();
    }
    maxSize = maxSize + size;
  }

  @Override
  public int getStackSize() {
    return top == null ? 0 : top.getIndex();
  }

  @Override
  public synchronized int getStackMaximumSize() {
    return maxSize;
  }

  @Override
  public boolean isFull() {
    return this.top != null && this.top.getIndex() == maxSize;
  }

  @Override
  public synchronized boolean isEmpty() {
    return top == null;
  }
}
