public class BinarySearch {

    int[] Array;
    int Left; int Right;
    Boolean Find;

    public BinarySearch(int[] array) {
        Array = array;
        Left = 0; Right = array.length - 1;
        Find = false;
    }

    public void Step(int key) {
        int mid = (Left + Right + 1) / 2;

        if (Array[mid] == key)
            Find = true;

        if (Array[mid] < key)
            Left = mid + 1;

        if (Array[mid] > key)
            Right = mid - 1;
    }

    public int GetResult() {
        if (Find)
            return 1;

        if (Left > Right)
            return -1;
        else
            return 0;
    }
}
