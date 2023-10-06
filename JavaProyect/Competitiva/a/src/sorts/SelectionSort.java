package sorts;
import java.util.Comparator;
import java.util.Arrays;

public class SelectionSort<T extends Comparable<T>> {

    public void selectionSort(T[] arr) {
        selectionSort(arr, 0);
    }

    private void selectionSort(T[] arr, int startIndex) {
        if (startIndex >= arr.length - 1) {
            return;
        }

        int minIndex = min(arr, startIndex);
        if (minIndex != startIndex) {
            swap(arr, startIndex, minIndex);
        }

        selectionSort(arr, startIndex + 1);
    }

    private int min(T[] arr, int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex + 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[minIndex]) < 0) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

