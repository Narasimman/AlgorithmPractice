package ctci;

import ds.Stack;

public class StackWithMin extends Stack<Integer>{
  private Stack<Integer> sMin;
  
  public StackWithMin() {
    sMin = new Stack<Integer>();
  }
  
  public void push(int value) throws Exception {
    if(sMin.isEmpty()) {
      sMin.push(value);
    }

    if(value <= min()) {
      sMin.push(value);
    }
    super.push(value);
  }
  
  public Integer pop() throws Exception {
    if(super.isEmpty()) {
      throw new Exception("Stack Empty");
    }
    
    int item = super.pop();
    if(item == min()) {
      sMin.pop();
    }
    return item;
  }
  
  public int min() throws Exception{
    Integer item = sMin.peek();
    if( item == null) {
      
    }
    return item;
  }
  
  public static void main(String[] args) throws Exception {
    StackWithMin stack = new StackWithMin();
    
    stack.push(1);
    System.out.println(stack.min());
    stack.push(3);
    stack.push(0);
    stack.pop();
    System.out.println(stack.min());
    
  }
}
