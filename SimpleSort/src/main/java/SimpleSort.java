import java.util.*;

public class SimpleSort {

    public static int[] SelectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int index = i; int min = array[i];

            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            swap(array,index,i);
        }

        return array ;
    }


    public static int[] BubbleSort (int[] array) {
        boolean key = false;
        int last = array.length - 1;

        while (!key) {
            key = true;
            for (int i = 0; i < last; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array,i+1,i);
                    key = false;
                }
            }

            last--;
        }

        return array;
    }

    public static void swap(int[] array, int fromId, int toId){
        int c = array[fromId];
        array[fromId] = array[toId];
        array[toId] = c;
    }

}