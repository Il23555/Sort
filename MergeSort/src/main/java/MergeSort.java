import java.util.Arrays;

public class MergeSort {
    Heap MergeHeap = new Heap();
    HeapItem CurrentItem;
    int[] arr1, arr2;
    int i, j, in1 = 1, in2 = 2;

    public MergeSort (int[] MergeArray) {
        int mid = MergeArray.length/2;

        arr1 = new int[mid];
        for (int i = 0; i < mid; i++) {
            arr1[i] = MergeArray[i];
        }
        Arrays.sort(arr1);

        arr2 = new int[MergeArray.length - mid];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = MergeArray[i + mid];
        }
        Arrays.sort(arr2);

        i = arr1.length - 1; j = arr2.length - 1;
    }

    public void MergeSortStep () {
        if ((i >= 0) && (j >= 0)) {
            MergeHeap.Add(in1, arr1[i--]);
            MergeHeap.Add(in2, arr2[j--]);

            CurrentItem = MergeHeap.GetMax();

            if ((CurrentItem.key == in1) && (i > 0))
                MergeHeap.Add(in1,arr1[i--]);
            if ((CurrentItem.key == in2) && (j > 0))
                MergeHeap.Add(in2,arr2[j--]);
        }
        else {
            while (MergeHeap.Len() != 0)
                CurrentItem = MergeHeap.GetMax();
            while (j >= 0)
                CurrentItem = new HeapItem(in2, arr2[j--]);
            while (i >= 0)
                CurrentItem = new HeapItem(in1, arr1[i--]);
            CurrentItem = null;
        }
    }

}

class Heap {

    public HeapItem [] HeapArray; // хранит неотрицательные числа-ключи

    public Heap() {
        HeapArray = new HeapItem[2];
    }

    //Просеивание вниз
    private void SiftDown(int index){
        int largest = index;

        if ((2*index + 1 < HeapArray.length) && (HeapArray[2*index + 1] != null) && (HeapArray[largest].value < HeapArray[2*index + 1].value))
            largest = 2*index + 1;
        if ((2*index + 2 < HeapArray.length) && (HeapArray[2*index + 2] != null) && (HeapArray[largest].value < HeapArray[2*index + 2].value))
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
        if ((index > 0) && (HeapArray[index].value >= HeapArray[parent].value)) {
            HeapItem temp = HeapArray[index];
            HeapArray[index] = HeapArray[parent];
            HeapArray[parent] = temp;

            SiftUp(parent);
        }
    }

    public boolean Add(int key, int value) // добавляем новый элемент key в кучу и перестраиваем её
    {
        //найти последний пустой слот
        int index = HeapArray.length - 1;
        while ((index >= 0) && (HeapArray[index] == null)){
            index--;
        }
        index++;

        if (index != HeapArray.length){
            HeapItem Item = new HeapItem(key,value);
            HeapArray[index] = Item;
            SiftUp(index);
            return true;
        }
        return false; // если куча вся заполнена
    }

    public HeapItem GetMax()// вернуть значение корня и перестроить кучу
    {
        if (HeapArray == null)
            return null;

        //найти последний элемент
        int index = HeapArray.length - 1;
        while ((index >= 0) && (HeapArray[index] == null)) {
            index--;
        }

        if (index >= 0){
            HeapItem temp = HeapArray[0];
            HeapArray[0] = HeapArray[index];
            HeapArray[index] = null;
            SiftDown(0);
            return temp;
        }

        return null; // если куча пуста
    }

    public int Len() {
        int index = HeapArray.length - 1;
        while ((index >= 0) && (HeapArray[index] == null)) {
            index--;
        }
        index++;

        return index;
    }
}

class HeapItem {
    int key, value;

    public HeapItem (int key, int value) {
        this.key = key;
        this.value= value;
    }
}