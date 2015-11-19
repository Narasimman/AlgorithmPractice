package ds;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Tree<T extends Comparable<T>> {

  private Node<T> root;

  private static class Node<E extends Comparable<E>> {
    private E value;
    private Node<E> left;
    private Node<E> right;

    Node(E value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public void insert(T value) {
    Node<T> node = new Node<T>(value);
    if(root == null) {            
      root = node;
    } else {
      insert(root, node);
    }
  }

  public void insert(Node<T> root, Node<T> node) {
      if(node.value.compareTo(root.value) < 0) {
        if(root.left == null) {
          root.left = node;
        } else {
          insert(root.left, node);
        }
      } else {
        if(root.right == null) {
          root.right = node; 
        } else {
          insert(root.right, node);
        }
      }
    
  }

  public void inorder() {
    System.out.println("Inorder recursive");
    this.inorder(root);
    System.out.println();
  }

  private void inorder(Node<T> root) {
    if(root == null)
      return;

    inorder(root.left);
    System.out.print(" " + root.value);
    inorder(root.right);
  }

  public void inorderIterative() {
    System.out.println("Iterative inorder");
    Stack<Node<T>> stack = new Stack<Node<T>>();
    Node<T> node = root;
    stack.push(node);
    while(!stack.isEmpty()) {
      if(node != null) {
        stack.push(node);
        node = node.left;
      } else {
        node = stack.pop();
        System.out.print(" " + node.value);
        node = node.right;
      }
    }
    System.out.println();
  }

  public void preorderIterative() {
    System.out.println("Pre order iterative");
    Stack<Node<T>> stack = new Stack<Node<T>>();
    stack.push(root);
    Node<T> node = root;

    while(!stack.isEmpty()) {
      System.out.print(" " + node.value);

      if(node.right != null) {
        stack.push(node);
      }      
      if(node.left != null) {
        node = node.left;
        continue;
      }      
      if(!stack.isEmpty()) {
        node = stack.pop();
        node = node.right;
      }      
    }
    System.out.println();
  }

  public void treeMirror() {
    System.out.println("Mirror");
    treeMirrorUtil(root);
    System.out.println();
  }

  private void treeMirrorUtil(Node<T> node) {
    if(node == null) {
      return;
    }

    Node<T> temp = node.left;
    node.left = node.right;
    node.right = temp;
    
    treeMirrorUtil(node.left);
    System.out.print(" " + node.value);
    treeMirrorUtil(node.right);
    
    
  }

  public void isBST() {
    System.out.println("IS BST:");
    System.out.print(isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    System.out.println();
  }
  
  private boolean isBSTUtil(Node<T> root, int min, int max) {
    if(root == null) {
      return true;
    }
    
    if((Integer)root.value > max || (Integer)root.value < min) {
      return false;
    }
    
    return isBSTUtil(root.left, min, (Integer)root.value) && 
        isBSTUtil(root.right, (Integer)root.value, max);    
  }
  
  private void levelOrderTraversal() {
    if(root == null) {
      return;
    }
    
    Queue<Node<T>> queue = new ArrayDeque<Node<T>>();
    queue.add(root);
    
    while(!queue.isEmpty()) {
      Node<T> node = queue.poll();
      
      if(node.left != null) {
        queue.add(node.left);
      }
      
      if(node.right != null) {
        queue.add(node.right);
      }
      
      System.out.println(node.value);
    }
    
  }

  public static void main(String[] args) {
    Tree<Integer> tree = new Tree<Integer>();

    tree.insert(6);
    tree.insert(4);
    tree.insert(3);
    tree.insert(5);
    tree.insert(8);
    tree.insert(7);
    tree.insert(9);

    tree.inorder();

    tree.inorderIterative();

    tree.preorderIterative();

    //tree.treeMirror();

    Tree<Integer> tree1 = new Tree<Integer>();
    tree1.root = new Node<Integer>(4);
    tree1.root.left = new Node<Integer>(2);
    tree1.root.right = new Node<Integer>(6);
    tree1.root.left.right = new Node<Integer>(3);
    tree1.root.left.left = new Node<Integer>(1);
    tree.isBST(); 
    
    
    tree.levelOrderTraversal();
    
  } 
}
