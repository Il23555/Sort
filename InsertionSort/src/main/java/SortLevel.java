import java.util.*;

public class SortLevel {

    public static int[] InsertionSortStep (int[] array, int step,int i){

        while (i < array.length) {
            int j = i - step;
            while (j >= 0) {
                if (array[j] > array [j + step])
                    swap(array,j,j+step);
                j = j - step;
            }
            i = i + step;
        }

        return array ;
    }

    public static ArrayList<Integer> KnuthSequence (int array_size ){
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = 1;
        while (n < array_size) {
            list.add(0,n);
            n = n * 3 + 1;
        }
        return list;
    }


    public static void swap(int[] arr, int fromIdx, int toIdx) {
        int a = arr[fromIdx];
        arr[fromIdx] = arr[toIdx];
        arr[toIdx] = a;
    }
}


