import java.util.*;

public class InsertionSort {

    public static int[] InsertionSort (int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (array[j] < array [j - 1])
                    swap(array,j,j-1);
            }
        }
        return array ;
    }

    public static void swap(int[] arr, int fromIdx, int toIdx) {
        int a = arr[fromIdx];
        arr[fromIdx] = arr[toIdx];
        arr[toIdx] = a;
    }
}


