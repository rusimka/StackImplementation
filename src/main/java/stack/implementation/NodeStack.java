package stack.implementation;

import stack.Node;
import stack.Stack;
import stack.exceptions.*;


public class NodeStack<E> implements Stack<E> {

  public Node<E> top;
  public int maxSize;

  public NodeStack(int maxSize)  {
    if (maxSize <= 0) {
      throw new stack.exceptions.MaximumSizeSmallerOrEqualToZeroException();
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
      throw new StackIsAlreadyEmptyException();
    }
    return top.getData();
  }

  @Override
  public void grow(int size)  {
    if(size<0){
      throw new stack.exceptions.NegativeNumberException(size);
    }
    if(size > Integer.MAX_VALUE - maxSize ){
      throw new stack.exceptions.IntegerOverflowException();
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
