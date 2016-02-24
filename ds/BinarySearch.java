package ds;

public class BinarySearch {

  private static int search(int arr[], int k) {
    int l = 0;
    int r = arr.length;
    
    while(l <= r) {
      int m = l + (r -l)/2;
      
      if(arr[m] == k) {
        return m;
      }
      
      if(k < arr[m]) {
        r = m - 1;
      } else {
        l = m + 1;
      }
      
    }
    return -1;
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] arr = {2,5,6,8,9,10,11,16};
    System.out.print(search(arr, 11));
  }

}
