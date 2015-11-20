package ds;

public class Arrays {

  private static int findElementInRotated(int[] input, int val) {
    int l = 0;
    int r = input.length - 1;
    
    while(l <= r) {
      int m = l + (r - l)/2;
      
      if(input[m] == val) {
        return m;
      }
      
      //lower half sorted
      if(input[l] <= input[m]) {
        if(input[l] <= val && val < input[m]) {
          r = m - 1;
        } else {
          l = m + 1;
        }
      } else {
        //upper half is sorted
        if(input[m] < val && val <= input[r]) {
          l = m + 1;
        } else {
          r = m - 1;
        }
      }      
    }
    return -1;
  }
  
  private static int findPivot(int[] input) {
    int l = 0, r = input.length - 1;
    
    while(input[l] > input[r]) {
      int m = l + (r - l)/2;
      
      if(input[m] > input[r]) {
        l = m + 1;
      } else {
        r = m;
      }
    }
    return l;
  }
  
  public static void main(String[] args) {
    int[] input = {2,3,4,5,6,7,0,1};
    System.out.println(findElementInRotated(input, 6));
    System.out.println(findPivot(input));
  }

}
