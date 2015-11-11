package ds;

public class LinkedList<T> {
    
  private Node<T> head;

  private class Node<T> {
    private T value;
    private Node<T> next;

    Node(T value) {
      this.value = value;
      this.next = null;
    }
  }
  
  void add(T value) {
    Node<T> newNode = new Node<T>(value);
    if (head == null) {
      head = newNode;
    } else {
      Node<T> current = head;
      while(current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  void printList() {
    Node<T> current = head;
    while(current != null) {
      System.out.print(current.value);
      current = current.next;
      if(current != null) {
        System.out.print("  ->  ");
      }
    }
    System.out.println();
  }

  void reverse() {
    System.out.println("Reverse");
    if (head == null || head.next == null) {
      return;
    }

    Node<T> prev = null;
    Node<T> current = head;
    Node<T> next = null;

    while(current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;    
  }

  void pairWiseSwap() {
    System.out.println("Pair wise swap");
    if (head == null || head.next == null) {
      return;
    }

    Node<T> prev = null;
    Node<T> current = head;
    Node<T> next = head.next;

    head = current.next;

    while(current != null && next != null) {      
      if (prev != null) {
        prev.next = next;
      }     
      current.next = next.next;
      next.next = current;
      
      prev = current;
      current = current.next;
      next = current.next;
    }
  }

  Node<T> kthFromLast(int k) {
    int count = 0;
    Node<T> current = head, tail = head;
    
    while (count < k && tail != null) {
      tail = tail.next;
      count++;
    }
    
    if(count < k) {
      return null;
    }
    
    while(tail != null) {
      current = current.next;
      tail = tail.next;
    }
    System.out.println(k + "->  Kth from last : " + current.value);
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
