public class HeapSort {

    Heap HeapObject;

    public HeapSort(int[] array) {
        HeapObject = new Heap();
        HeapObject.MakeHeap(array.length);

        for (int i = 0; i < array.length; i++) {
            HeapObject.Add(array[i]);
        }
    }

    public int GetNextMax() {

        return HeapObject.GetMax();
    }

}

class Heap
{
    public int [] HeapArray; // хранит неотрицательные числа-ключи
    public Heap() { HeapArray = null; }

    public void MakeHeap(int len){
        HeapArray = new int[len];
    }
    public int GetMax()// вернуть значение корня и перестроить кучу
    {
        if (HeapArray == null)
            return -1;

        //найти последний элемент
        int index = HeapArray.length -1;
        while ((index >= 0) && (HeapArray[index] == 0)) {
            index--;
        }

        if (index >= 0){
            int temp = HeapArray[0];
            HeapArray[0] = HeapArray[index];
            HeapArray[index] = 0;
            SiftDown(0);
            return temp;
        }

        return -1; // если куча пуста
    }

    public boolean Add(int key) // добавляем новый элемент key в кучу и перестраиваем её
    {
        //найти последний пустой слот
        int index = HeapArray.length -1;
        while ((index > 0) && (HeapArray[index] == 0)){
            index--;
        }
        index++;

        if (index != HeapArray.length){
            HeapArray[index] = key;
            SiftUp(index);
            return true;
        }
        return false; // если куча вся заполнена
    }

    //Просеивание вниз
    private void SiftDown(int index){
        int largest = index;

        if ((2*index + 1 < HeapArray.length) && (HeapArray[largest] < HeapArray[2*index + 1]))
            largest = 2*index + 1;
        if ((2*index + 2 < HeapArray.length) && (HeapArray[largest] < HeapArray[2*index + 2]))
            largest = 2*index + 2;

        if (largest != index){
            int temp = HeapArray[index];
            HeapArray[index] = HeapArray[largest];
            HeapArray[largest] = temp;

            SiftDown(largest);
        }
    }

    //Проталкивание вверх
    private void SiftUp(int index){
        int parent = (index-1)/2;
        if ((index > 0) && (HeapArray[index] >= HeapArray[parent])) {
            int temp = HeapArray[index];
            HeapArray[index] = HeapArray[parent];
            HeapArray[parent] = temp;
            SiftUp(parent);
        }
    }
}