public class GallopingSearch {

    int[] Array;
    int Left; int Right;
    int Result;

    public GallopingSearch(int[] array) {
        Array = array;
        Left = 0; Right = array.length - 1;
        Result = 0;
    }

    public void Step(int key) {

        if (Left > Right) {

            if (Array[Right] == key) {
                Left = Right;
                Result = 1;
            }

            if (Array[Right] > key)
                New_Array(Left/2,Right);

            if (Array[Right] < key)
                Result = -1;
        }
        else {

            if (Array[Left] == key) {
                Right = Left;
                Result = 1;
            }

            if (Array[Left] > key)
                New_Array(Left/2,Left);

            if (Array[Left] < key)
                Left = (Left == 0) ? 1 : Left * 2;

        }
    }

    private void New_Array(int l,int r){
        int count = r - l + 1;

        int[] temp = new int[count];
        for (int i = 0; i < count; i++) {
            temp[i] = Array[i + l];
        }

        Array = new int[count];
        for (int i = 0; i < count; i++) {
            Array[i] = temp[i];
        }
        Left = 0; Right = count - 1;
    }

    public int GetResult() {

        return Result;
    }
}
