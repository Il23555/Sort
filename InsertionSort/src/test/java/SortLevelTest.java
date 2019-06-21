import static org.junit.Assert.*;

public class SortLevelTest {

    @org.junit.Test
    public void insertionSortStep() {
        int[] arr = new int[] {7,6,5,4,3,2,1};
        SortLevel.InsertionSortStep(arr,1,0);
        for (int a : arr){
                System.out.print(a);
        }


    }
}