import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class InsertionSortTest {
    @Test
    public void insertionSort() {
        int[] arr = new int[] {7,6,5,4,3,2,1};
        InsertionSort.InsertionSort(arr);
        for (int i = 0; i < arr.length ; i++) {
            assertEquals(i+1,arr[i]);
        }
    }
}