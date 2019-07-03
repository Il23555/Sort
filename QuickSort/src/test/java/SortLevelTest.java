import org.junit.Test;
import static org.junit.Assert.*;

public class SortLevelTest {

    @Test
    public void quickSort() {
        int[] arr = new int[]{2,1,3,0,8,4,9,6,5,7};
        SortLevel.QuickSort(arr,0, arr.length-1);
        for (int i = 0; i < arr.length ; i++) {
            assertEquals(i,arr[i]);
        }
    }

    @Test
    public void quickSortTailOptimization() {
        int[] arr = new int[]{2,1,3,0,8,4,9,6,5,7};
        SortLevel.QuickSortTailOptimization(arr,0, arr.length-1);
        for (int i = 0; i < arr.length ; i++) {
            assertEquals(i,arr[i]);
        }
    }
}