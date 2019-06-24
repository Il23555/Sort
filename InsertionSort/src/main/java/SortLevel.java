import java.util.*;

public class SortLevel {

    public static int[] InsertionSortStep (int[] array, int step,int i){

        while (i < array.length) {
            int j = i - step;
            while (j >= 0) {
                if (array[j] > array [j + step])
                    swap(array,j,j+step);
                j = j - step;
            }
            i = i + step;
        }

        return array ;
    }

    public static ArrayList<Integer> KnuthSequence(int array_size ) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);

        int n = 4;
        while (n < array_size) {
            list.add(0,n);
            n = n * 3 + 1;
        }

        return list;
    }

    public static int ArrayChunk( int[] M ){
        int index = M.length/2;
        int N = M[index];
        int i1 = 0; int i2 = M.length - 1;

        while ((i1 != i2) || ((i1 == i2 - 1) && (M[i1] < M[i2]))){
            while (M[i1] < N)
                i1++;
            while (M[i2] > N)
                i2--;

            if ((i1 == i2 - 1) && (M[i1] > M[i2])) {
                swap(M,i1,i2);
                i1 = 0; i2 = M.length - 1;
                N = M[index];
            }
            if ((M[i1] >= N) && (M[i2] <= N))
                swap(M, i1, i2);
        }

        return index;
    }

    public static void swap(int[] arr, int fromIdx, int toIdx) {
        int a = arr[fromIdx];
        arr[fromIdx] = arr[toIdx];
        arr[toIdx] = a;
    }
}


