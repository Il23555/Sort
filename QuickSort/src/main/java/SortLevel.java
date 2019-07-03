public class SortLevel {

    public static void QuickSort (int[] array, int left, int right) {
        if (left <= right) {
            int pivot = array[(left + right) / 2];
            int i = left;
            int j = right;
            while (i < j) {
                while (array[i] < pivot)
                    i++;
                while (array[j] > pivot)
                    j--;
                if (i < j)
                    swap(array, i, j);
            }
            QuickSort(array,left,i-1);
            QuickSort(array,i+1,right);
        }
    }

    public static void QuickSortTailOptimization (int[] array, int left, int right) {
        while (left < right) {
            int pivot = array[(left + right) / 2];
            int i = left;
            int j = right;
            while (i < j) {
                while (array[i] < pivot)
                    i++;
                while (array[j] > pivot)
                    j--;
                if (i < j)
                    swap(array, i, j);
            }
            if (i - left < right - i) {
                QuickSortTailOptimization(array,left,i-1);
                left = i + 1;
            }
            else {
                QuickSortTailOptimization(array,i+1,right);
                right = i - 1;
            }
        }
    }

    public static void swap(int[] arr, int fromIdx, int toIdx) {
        int a = arr[fromIdx];
        arr[fromIdx] = arr[toIdx];
        arr[toIdx] = a;
    }
}