import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SortLevelTest {

    @org.junit.Test
    public void insertionSortStep() {
        int[] arr = new int[] {7,6,5,4,3,2,1};
        SortLevel.InsertionSortStep(arr,1,0);
        for (int i = 0; i < arr.length ; i++) {
            assertEquals(i+1,arr[i]);
        }
    }

    @Test
    public void knuthSequence() {
        ArrayList<Integer> list = SortLevel.KnuthSequence(15);
        assertEquals((Integer)13, list.get(0));
        assertEquals((Integer)4, list.get(1));
        assertEquals((Integer)1, list.get(2));
    }
}