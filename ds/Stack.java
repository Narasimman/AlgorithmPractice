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
    } else {
      node.next = top;
      top = node;
    }
  }
  
  public T pop() {
    if(top == null) {
      return null;
    } else {
      T item = top.value;
      top = top.next;
      return item;
    }
  }
  
  public boolean isEmpty() {
    return (top == null);
  }
  
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.pop();
    stack.pop();
    stack.pop();
  }
}
