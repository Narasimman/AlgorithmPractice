package ds;

public class Strings {

  private static boolean isBalancedParanthesis(String str) {
    if(str.length() < 2 || str.length()%2 == 1) {
      return false;
    }

    Stack<Character> stack = new Stack<Character>();

    char[] cStr = str.toCharArray();

    for(int i = 0; i < cStr.length; i++) {
      char val = cStr[i];
      if(val == '{') {
        stack.push(val);
      } else if(val == '}'){
        if(stack.isEmpty()) {
          return false;
        } else {
          stack.pop();
        }
      }
    }
    if(stack.isEmpty()) {
      return true;
    }
    return false;
  }

  private static String reverseInput(String str) {
    String result = "";
    int i = 0;
    while(i < str.length()) {
      String substr = "";
      while(i < (str.length()) && str.charAt(i) != ' ') {
        substr += str.charAt(i);
        i++;
      }        

      result += reverse(substr);
      if(i < str.length()) {
        result += str.charAt(i);
        i++;
      }
    }
    return result;
  }

  private static String reverse(String str) {
    if(str.length() < 2) {
      return str;
    }
    return reverse(str.substring(1)) + str.charAt(0);
  }

  public static void main(String[] args) {
    System.out.println(isBalancedParanthesis("{{{}}{}}}}"));
    System.out.println(reverseInput("abc def gh"));
    
  }

}
