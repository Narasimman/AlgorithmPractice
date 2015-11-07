package ds;

public class Node<T> {
  private T value;
  private Node<T> next;

  Node(T value) {
    this.value = value;
    this.next = null;
  }
  public Node<T> getNext() {
    return next;
  }
  
  public void setNext(Node<T> node) {
    this.next = node;
  }

  public T getValue() {
    return value;
  }
}
