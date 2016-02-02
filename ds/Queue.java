package ds;

public class Queue<T> {

  public Node<T> front;
  public Node<T> rear;

  private static class Node<E> {
    E value;
    Node<E> next;

    Node(E value) {
      this.value = value;
      this.next = null;
    }
  }

  public void add(T item) {
    Node<T> node = new Node<T>(item);

    if(rear != null) {
      rear.next = node;
    }

    rear = node;

    if(front == null) {
      front = rear;
    }
  }

  public T remove() throws Exception {
    if(front == null) {
      throw new Exception("Queue Underflow");
    }

    T item = front.value;
    front = front.next;

    return item;
  }

  public boolean isEmpty() {
    return front == null;
  }
}
