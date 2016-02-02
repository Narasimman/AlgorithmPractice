package ctci;

public class UniqueCharacters {

  /**
   * Does the string has unique characters?
   * Uses extra memory
   * @param input
   * @return
   */
  private static boolean isUniqueChars(String input) {
    if(input != null && input.length() < 1) {
      return false;
    }
    
    boolean[] ascii_set = new boolean[128];    
    char[] inputChars = input.toCharArray();
    
    for(char c : inputChars) {
      if(ascii_set[c]) {
        return false;
      }
      ascii_set[c] = true;
    }
    return true;
  }

  public static void main(String[] args) {
    String input = "afsd";
    System.out.println("input: " + input);
    System.out.println("is Unique: " + isUniqueChars(input));
  }
}