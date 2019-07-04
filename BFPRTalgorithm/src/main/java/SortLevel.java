import java.util.ArrayList;

public class SortLevel {

    public static ArrayList<Integer> KthOrderStatisticsStep (int[] Array, int L, int R, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        //сортируем массивы по 5 элементов
        int step = 5;
        int be = L; int en = L + (step - 1);
        while (en <= R) {
            insertionSort(Array,be,en,1);
            be += step; en += step;
        }
        insertionSort(Array, be, R,1);

        //сортируем медианы
        insertionSort(Array,step/2 + L, R, step);

        //находим позицию медианы
        int index = (L + R)/10 * 5 + 2;
        int pos = partition(Array, L, R, index);

        //записываем границы
        if (pos >= k)
            list.add(L);
        else
            list.add(pos + 1);

        if (pos <= k)
            list.add(R);
        else
            list.add(pos - 1);

        return list;
    }

    public static void insertionSort(int[] array, int left, int right,int step){

        for (int i = left + step; i <= right; i+=step) {
            for (int j = i; j > left; j -= step) {
                if (array[j - step] > array[j])
                    swap(array,j - step,j);
            }
        }
    }

    public static int partition(int[] array, int left, int right, int index){

        int pivot = array[index];
        int i = left; int j = right;

        while (i < j) {
            while (array[i] < pivot)
                i++;
            while (array[j] > pivot)
                j--;
            if (i < j)
                swap(array,i,j);
        }

        return i;
    }

    public static void swap(int[] array, int i, int j) {

        int c = array[i];
        array[i] = array[j];
        array[j] = c;
    }
}
