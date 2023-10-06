package sorts;

import java.util.Comparator;
import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> {
    
    public void bubbleSort(T[] array, int n) {
        if (n <= 1) {
            return; 
        }

        for (int i = 0; i < n - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                T temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }

        bubbleSort(array, n - 1);
    }
}


