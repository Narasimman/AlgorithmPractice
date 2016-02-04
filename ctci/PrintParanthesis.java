package ctci;

public class PrintParanthesis {

  private static void printparan(int l, int r, char[] str, int count) {
    //System.out.println(str);
    //System.out.println(l + " " + r);
    if(l == 0 && r == 0) {
      System.out.println(str);
      return;
    }
    
    if(l > 0) {
      str[count] = '(';
      //System.out.println("Left: " + l);
      //System.out.println("Count: " + count );
      printparan(l - 1, r, str, count + 1);
    }
    
    if(r > l) {
      str[count] = ')';
      //System.out.println("Right: " + r);
      //System.out.println("Count: " + count );
      printparan(l, r - 1, str, count + 1);
    }
  }
  
  
  public static void main(String[] args) {
    int count  = 3;
    char[] str = new char[count*2];
    PrintParanthesis.printparan(count, count, str, 0);
  }

}
