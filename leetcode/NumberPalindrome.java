package leetcode;

public class NumberPalindrome {
  public static boolean isPalindrome(int x) {
    if(x < 0) { 
      return false;
    }

    int divider = 1;

    while(x / divider >= 10) {
      divider *= 10;
    }

    while (x > 0) {
      int left = x / divider;
      int right = x % 10;
      if (left != right) {
        return false;
      }

      x = (x%divider)/10;
      divider /= 100;
    }

    return true;

  }
  public static void main(String[] args) {
     System.out.println(isPalindrome(10301));
  }

}
