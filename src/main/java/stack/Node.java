package stack;

public class Node<E> {

  public  E data;
  public Node<E> next;

  private int index = 0;

  public Node(E data,Node next) {
    this.data = data;
    this.next = next;
    this.index = next == null ? 1 : next.index + 1;


  }

  public E getData() {
    return data;
  }

  public Node<E> getNext() {
    return next;
  }

  public void setNext(Node<E> next) {
    this.next = next;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  @Override
  public String toString() {
    return data.toString();
  }

}
