import java.util.Arrays;

public class MergeSort {

    Heap MergeHeap;
    HeapItem CurrentItem;
    int[] MergeArray;
    int in1 = 1, in2 = 2;
    int i, j, mid;

    public MergeSort (int[] array) {

        MergeHeap = new Heap();
        MergeArray = array;

        //разделяем на 2 подмассива, устанавливаем позиции
        mid = MergeArray.length/2;
        i = 0; j = mid;

        //сортируем
        Arrays.sort(MergeArray, 0, mid);
        Arrays.sort(MergeArray, mid, MergeArray.length);

        //переворачиваем
        int m = mid/2;
        for (int k = 0; k < m; k++) {
            int temp = MergeArray[k];
            MergeArray[k] = MergeArray[mid - 1 - k];
            MergeArray[mid - 1 - k] = temp;
        }

        m = (MergeArray.length + mid)/2;
        for (int k = mid; k < m; k++) {
            int temp = MergeArray[k];
            MergeArray[k] = MergeArray[MergeArray.length - 1 - k + mid];
            MergeArray[MergeArray.length - 1 - k + mid] = temp;
        }

    }

    public void MergeSortStep () {

        if (i < mid)
            MergeHeap.Add(MergeArray[i++], in1);

        if (j < MergeArray.length)
            MergeHeap.Add(MergeArray[j++], in2);

        if (MergeHeap.Len() > 0)
            CurrentItem = MergeHeap.GetMax();
        else
            CurrentItem = null;
    }

}

class Heap {

    public HeapItem[] HeapArray; // хранит неотрицательные числа-ключи
    public int Count;

    public Heap() {
        HeapArray = new HeapItem[100];
        Count = 0;
    }

    //Просеивание вниз
    private void SiftDown(int index){
        int largest = index;

        if ((2*index + 1 < HeapArray.length) && (HeapArray[2*index + 1] != null) && (HeapArray[largest].key < HeapArray[2*index + 1].key))
            largest = 2*index + 1;
        if ((2*index + 2 < HeapArray.length) && (HeapArray[2*index + 2] != null) && (HeapArray[largest].key < HeapArray[2*index + 2].key))
            largest = 2*index + 2;

        if (largest != index){
            HeapItem temp = HeapArray[index];
            HeapArray[index] = HeapArray[largest];
            HeapArray[largest] = temp;

            SiftDown(largest);
        }
    }

    //Проталкивание элемента вверх
    private void SiftUp(int index){
        int parent = (index - 1)/2;
        if ((index > 0) && (HeapArray[index].key >= HeapArray[parent].key)) {
            HeapItem temp = HeapArray[index];
            HeapArray[index] = HeapArray[parent];
            HeapArray[parent] = temp;

            SiftUp(parent);
        }
    }

    public boolean Add(int key, int value) // добавляем новый элемент key в кучу и перестраиваем её
    {
        int index = Count;

        if (index != HeapArray.length){
            HeapItem Item = new HeapItem(key,value);
            HeapArray[index] = Item;
            Count++;
            SiftUp(index);
        }

        return (index != HeapArray.length); // если куча вся заполнена
    }

    public HeapItem GetMax()// вернуть значение корня и перестроить кучу
    {
        if (HeapArray == null)
            return null;

        //найти последний элемент
        int index = Count - 1;

        if (index >= 0){
            HeapItem temp = HeapArray[0];
            HeapArray[0] = HeapArray[index];
            HeapArray[index] = null;
            Count--;
            SiftDown(0);
            return temp;
        }

        return null; // если куча пуста
    }

    public int Len() {
        return Count;
    }
}

class HeapItem {
    int key, value;

    public HeapItem (int key, int value) {
        this.key = key;
        this.value= value;
    }
}