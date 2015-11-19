package sorts;

public class MergeSort {
  private static int[] arr;

  private static void merge(int[] arr, int low, int middle, int high) {

    int[] aux = new int[arr.length];
    for (int i = low; i <= high; i++) {
      aux[i] = arr[i];
    }

    int i = low;
    int j = middle + 1;
    int k = low;

    while (i <= middle && j <= high) {
      if (aux[i] <= aux[j]) {
        arr[k] = aux[i];
        i++;
      } else {
        arr[k] = aux[j];
        j++;
      }
      k++;
    }

    while (i <= middle) {
      arr[k] = aux[i];
      k++;
      i++;
    }
    
    while (j <= high) {
      arr[k] = aux[j];
      k++;
      j++;
    }
  }
  
  public static void mergeSort(int[] arr, int low, int high) {
    if(low >= high) {
      return;
    }
    
    int middle = low + (high - low) / 2;

    mergeSort(arr, low, middle);
    mergeSort(arr, middle + 1, high);
    merge(arr, low, middle, high);
  }  

  public static void main(String[] args) {
    int[] input = {4,1,8,3,2,5,9,3,7};
    
    arr = input;
    MergeSort.mergeSort(arr, 0, arr.length - 1);

    for(int i = 0; i < input.length; i++) {
      System.out.println(input[i]);
    }

  }

}
