package stack;

public class Node<E> {

  public final E data;
  public Node<E> next;

  public Node(E data,Node next) {
    this.data = data;
    this.next = next;
  }

  @Override
  public String toString() {
    return data.toString();
  }

}
