import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.*;

public class SortLevel
{
    public static int[] SelectionSortStep(int[] array, int i ){
        int min = array[i]; int index = i;
        for (int j = i+1; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
                index = j;
            }
        }
        int c = array[index];
        array[index] = array[i];
        array[i] = c;

        return array ;
    }

    public static boolean BubbleSortStep(int[] array)
    {
        boolean key = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i+1]) {
                int c = array[i+1];
                array[i+1] = array[i];
                array[i] = c;
                key = false;
            }
        }
        return key;
    }

}