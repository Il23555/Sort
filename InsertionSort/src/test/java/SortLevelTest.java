import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class SortLevelTest {

    @Test
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

    @Test
    public void arrayChunk() {
        int[] arr1 = new int[] {7,5,6,4,3,1,2};
        SortLevel.ArrayChunk(arr1);
        int[] answer1 = new int[] {2,1,3,4,6,5,7};
        for (int i = 0; i < arr1.length ; i++) {
            assertEquals(answer1[i],arr1[i]);
        }

        int[] arr2 = new int[] {1,0,2,4,3,7};
        SortLevel.ArrayChunk(arr2);
        int[] answer2 = new int[] {1,0,2,3,4,7};
        for (int i = 0; i < arr2.length ; i++) {
            assertEquals(answer2[i],arr2[i]);
        }
    }
}