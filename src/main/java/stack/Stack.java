package stack;

import stack.exceptions.NotAllowedSize;

public interface Stack<E> {
  public void push(E element);

  public E pop();

  public E peek();

  public void grow(int size) throws NotAllowedSize;

  public int getStackSize();

  public int getStackMaximumSize();

  public boolean isFull();

  public boolean isEmpty();
}
