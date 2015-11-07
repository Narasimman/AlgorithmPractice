package ds;

public class LinkedList<T> {
  private Node<T> head;

  void add(T value) {
    Node<T> newNode = new Node<T>(value);
    if (head == null) {
      head = newNode;
    } else {
      Node<T> current = head;
      while(current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }
  }

  void printList() {
    Node<T> current = head;
    while(current != null) {
      System.out.println(" -> " + current.getValue());
      current = current.getNext();
    }
  }
  
  void reverse() {
    if (head == null || head.getNext() == null) {
      return;
    }
    
    Node<T> prev = null;
    Node<T> current = head;
    Node<T> next = null;
    
    while(current != null) {
      next = current.getNext();
      current.setNext(prev);
      prev = current;
      current = next;
    }
    head = prev;    
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    list.printList();
    list.reverse();
    System.out.println("Reverse");
    list.printList();

  }
}
