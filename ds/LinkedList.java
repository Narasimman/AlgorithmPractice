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
      System.out.print(current.getValue());
      current = current.getNext();
      if(current != null) {
        System.out.print("  ->  ");
      }
    }
    System.out.println();
  }

  void reverse() {
    System.out.println("Reverse");
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

  void pairWiseSwap() {
    System.out.println("Pair wise swap");
    if (head == null || head.getNext() == null) {
      return;
    }

    Node<T> prev = null;
    Node<T> current = head;
    Node<T> next = head.getNext();

    head = current.getNext();

    while(current != null && next != null) {      
      if (prev != null) {
        prev.setNext(next);
      }     
      current.setNext(next.getNext());
      next.setNext(current);
      
      prev = current;
      current = current.getNext();
      next = current.getNext();
    }
  }

  Node<T> kthFromLast(int k) {
    int count = 0;
    Node<T> current = head, tail = head;
    
    while (count < k && tail != null) {
      tail = tail.getNext();
      count++;
    }
    
    if(count < k) {
      return null;
    }
    
    while(tail != null) {
      current = current.getNext();
      tail = tail.getNext();
    }
    System.out.println(k + "->  Kth from last : " + current.getValue());
    return current;    
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
    list.printList();

    list.pairWiseSwap();    
    list.printList();
    
    list.kthFromLast(2);

  }
}
