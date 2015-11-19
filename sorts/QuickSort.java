package sorts;

public class QuickSort {
  private static int[] arr;
  
  private static void swap(int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  private static int partition(int[] arr, int left, int right) {
    int i = left;
    int pivot = arr[right];
    
    for(int j = left; j < right; j++) {
      if(arr[j] <= pivot) {        
        swap(i,j);
        i++;
      }
    }

    swap(i, right);
    return i;
  }
  
  public static void quickSort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }

    int p = partition(arr, left, right);
    quickSort(arr, left, p - 1);
    quickSort(arr, p + 1, right);    
  }
  
  public static void main(String[] args) {
    int[] input = {4,1,8,3,2,5,9,3,7};
    
    arr = input;
    QuickSort.quickSort(arr, 0, arr.length - 1);

    for(int i = 0; i < input.length; i++) {
      System.out.println(input[i]);
    }

  }

}
