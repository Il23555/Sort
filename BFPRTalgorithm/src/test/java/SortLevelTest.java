import java.util.ArrayList;

import static org.junit.Assert.*;

public class SortLevelTest {

    @org.junit.Test
    public void kthOrderStatisticsStep() {
        int[] arr = new int[]{3,5,17,16,4,18,19,11,26,27,1,20,13,22,23,7,6,15,8,9,12,2,10,24,14,25,21};
        ArrayList<Integer> list = SortLevel.KthOrderStatisticsStep(arr,0,arr.length-1,14);
        for (int x: arr) {
            System.out.print(x);
        }
        System.out.println();
        for (Integer x: list) {
            System.out.print(x);
        }

        int[] arr2 = new int[]{0,5,6,2,4,3,1};
        ArrayList<Integer> list2 = SortLevel.KthOrderStatisticsStep(arr2,0,arr2.length-1,3);
        System.out.println();
        for (int x: arr2) {
            System.out.print(x);
        }
        System.out.println();
        for (Integer x: list2) {
            System.out.print(x);
        }
    }

    @org.junit.Test
    public void insertionSort() {
        int[] arr = new int[]{0,5,6,2,4,3,1};
        SortLevel.insertionSort(arr,0,arr.length-1,1);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(i,arr[i]);
        }
    }

    @org.junit.Test
    public void partition() {
        int[] arr = new int[]{0,5,6,2,4,3,1};
        int[] ans = new int[]{0,1,2,6,4,3,5};
        SortLevel.partition(arr,0,arr.length-1,3);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(ans[i],arr[i]);
        }
    }
}