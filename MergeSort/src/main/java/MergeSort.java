import java.util.Arrays;

public class MergeSort {

    Heap MergeHeap;
    HeapItem CurrentItem;
    int[] Array_1, Array_2;
    int in1 = 1, in2 = 2;
    int i, j;

    public MergeSort (int[] MergeArray) {

        MergeHeap = new Heap();

        //разделяем на 2 подмассива
        int mid = MergeArray.length/2;

        Array_1 = new int[mid];
        for (int i = 0; i < Array_1.length; i++) {
            Array_1[i] = MergeArray[i];
        }

        Array_2 = new int[MergeArray.length - mid];
        for (int i = 0; i < Array_2.length; i++) {
            Array_2[i] = MergeArray[i + mid];
        }

        //сортируем и устанавливаем позиции в подмассивах
        Arrays.sort(Array_1);
        Arrays.sort(Array_2);

        i = Array_1.length - 1;
        j = Array_2.length - 1;
    }

    public void MergeSortStep () {

        if ((i >= 0) && (j >= 0)) {
            MergeHeap.Add(in1, Array_1[i--]);
            MergeHeap.Add(in2, Array_2[j--]);

            CurrentItem = MergeHeap.GetMax();

            if ((CurrentItem.key == in1) && (i >= 0))
                MergeHeap.Add(in1,Array_1[i--]);
            if ((CurrentItem.key == in2) && (j >= 0))
                MergeHeap.Add(in2,Array_2[j--]);
        }
        else {
            while (i >= 0)
                CurrentItem = new HeapItem(in1, Array_1[i--]);
            while (j >= 0)
                CurrentItem = new HeapItem(in2, Array_2[j--]);
            CurrentItem = null;
        }
    }

}

class Heap {

    public HeapItem[] HeapArray; // хранит неотрицательные числа-ключи
    public int Count;

    public Heap() {
        HeapArray = new HeapItem[2];
        Count = 0;
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
            Count++;
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