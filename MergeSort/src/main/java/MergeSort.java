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
        i = mid - 1;
        j = MergeArray.length - 1;

        //сортируем
        Arrays.sort(MergeArray,0, mid);
        Arrays.sort(MergeArray, mid, MergeArray.length);
    }

    public void MergeSortStep () {

        if ((i >= 0) && (j >= mid)) {
            MergeHeap.Add(in1, MergeArray[i--]);
            MergeHeap.Add(in2, MergeArray[j--]);

            CurrentItem = MergeHeap.GetMax();

            if ((CurrentItem.key == in1) && (i >= 0))
                MergeHeap.Add(in1, MergeArray[i--]);
            if ((CurrentItem.key == in2) && (j >= mid))
                MergeHeap.Add(in2, MergeArray[j--]);
        }
        else {
            while (MergeHeap.Len() != 0)
                CurrentItem = MergeHeap.GetMax();
            while (i >= 0)
                CurrentItem = new HeapItem(in1, MergeArray[i--]);
            while (j >= mid)
                CurrentItem = new HeapItem(in2, MergeArray[j--]);
            CurrentItem = null;
        }
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