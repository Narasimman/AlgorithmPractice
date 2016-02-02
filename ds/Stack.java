package ds;

public class Stack<T> {
  private Node<T> top;

  private static class Node<E> {
    E value;
    Node<E> next;

    Node(E value) {
      this.value = value;
      this.next = null;
    }
  }

  public void push(T value) {
    Node<T> node = new Node<T>(value);
    if(top == null) {
      top = node;
    }
    node.next = top;
    top = node;
  }

  public T pop() throws Exception {
    if(top == null) {
      throw new Exception("Stack Empty");
    }

    T item = top.value;
    top = top.next;
    return item;
  }
  
  public T peek() throws Exception {
    if(top == null) {
      throw new Exception("Stack Empty");
    }
    return top.value;
  }

  public boolean isEmpty() {
    return (top == null);
  }
}
