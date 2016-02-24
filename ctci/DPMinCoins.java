package ctci;

public class DPMinCoins {
  static void minCoins(int[] coins, int sum) {
    int[] min = new int[sum + 1];

    for(int i = 0; i < min.length; i++) {
      min[i] = Integer.MAX_VALUE;
    }

    min[0] = 0;

    for(int i = 1; i <= sum; i++) {
      for(int j = 0; j < coins.length; j++) {
        if(coins[j] <= i){
          System.out.println("i= " + i + " j: " + j + " coins[]: " + coins[j] + " min[i]: " + min[i] + " min[i - coins[j]]: " + min[i - coins[j]]);
          if(coins[j] <= i && 
              min[i - coins[j]] + 1 < min[i]) {
            min[i] = min[i - coins[j]] + 1;
            System.out.println(i + " : " + min[i]);
          }
        }
      }
    }

    System.out.println(min[sum]);
  }


  public static void main(String[] args) {
    int[] coins = {1,3,5};
    minCoins(coins, 11);
  }

}
