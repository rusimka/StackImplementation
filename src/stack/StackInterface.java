package stack;

import stack.exceptions.NotAllowedSize;

public interface StackInterface<E> {

    public void push(E element);

    public E pop();

    public E peek();

    public void growSizeStack(int size) throws NotAllowedSize;

    public int getStackSize();

    public int getStackMaximumSize();

    public boolean isFull();

    public boolean isEmpty();

}
