package ds;

public class Tree<T extends Comparable<T>> {
    
  private Node<T> root;
  
  private class Node<T extends Comparable<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    Node(T value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
   }

  public void insert(T value) {
    root = insert(root, value);
  }
  
  public Node<T> insert(Node<T> root, T value) {
    Node<T> node = new Node<T>(value);
    if(root == null) {            
      root = node;
    } else {
      if(value.compareTo(root.value) < 0) {
        root.left = insert(root.left, value);
      } else {
        root.right = insert(root.right, value);
      }
    }
    return root;
  }
  
  public void inorder() {
    System.out.println("Inorder recursive");
    this.inorder(root);
  }
  
  private void inorder(Node<T> root) {
    if(root == null)
      return;
    
    inorder(root.left);
    System.out.println(root.value);
    inorder(root.right);
  }
  
  

  public static void main(String[] args) {
    Tree<Integer> tree = new Tree<Integer>();
    
    tree.insert(6);
    tree.insert(5);
    tree.insert(7);
    tree.insert(4);
    tree.insert(3);
    tree.insert(5);
    tree.insert(1);
    tree.insert(2);
    tree.insert(8);
    tree.insert(9);
    tree.insert(10);
    
    tree.inorder();
    
    
  } 
}
