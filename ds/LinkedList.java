package ds;

public class LinkedList<T> {

  private Node<T> head;

  private static class Node<E> {
    private E value;
    private Node<E> next;

    Node(E value) {
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

  Node<T> get(int index) {
    Node<T> current = head;
    int counter = 0;
    while(current != null && current.next != null) {
      if(counter == index) {
        return current;
      }
      current = current.next;
      counter++;
    }
    return null;
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

  Node<T> reverse(Node<T> node) {
    System.out.println("Reverse");
    if (node == null || node.next == null) {
      return node;
    }

    Node<T> prev = null;
    Node<T> current = node;
    Node<T> next = null;

    while(current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
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

  Node<T> findStartOfLoop() {
    Node<T> slow = head;
    Node<T> fast = head;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        break;
      }
    }

    slow = head;

    while(slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }

  boolean palindrome() {
    Node<T> fast = head;
    Node<T> slow = head;

    Stack<Node> stack = new Stack<>();

    while(fast != null && fast.next != null) {
      stack.push(slow);
      fast = fast.next.next;
      slow = slow.next;
    }
    
    if (fast != null && fast.next == null) {
      slow = slow.next;
    }

    while(slow != null) {      
      Node<T> node = stack.pop();
      if(slow.value != node.value) {
        return false;
      }
      slow = slow.next;
    }
    return true;
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(2);
    list.add(1);

    list.printList();

    list.head = list.reverse(list.head);
    list.printList();

    System.out.println("Palindrome: " + list.palindrome());


    /*list.pairWiseSwap();    
    list.printList();

    list.kthFromLast(2);

    LinkedList<Integer> loopList = new LinkedList<Integer>();

    for (int i = 0; i < 10; i++) {
      loopList.add(i);
    }

    Node<Integer> loop = loopList.get(5);
    Node<Integer> end = loopList.get(8);
    end.next = loop;

    System.out.println("Loop: " + loopList.findStartOfLoop().value);
     */





  }
}
