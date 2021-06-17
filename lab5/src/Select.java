package Zad1;

import java.util.Comparator;

public class Select<T> {
    private final Comparator<T> _comparator;
    public Select(Comparator<T> comparator) {
        _comparator = comparator;
    }
    public T[] sort(T[] list) {
        int size = list.length;
        for (int slot = 0; slot < size - 1; ++slot) {
            int smallest = slot; // pozycja wartości minimalnej
            for (int check = slot + 1; check < size; ++check)
                if (_comparator.compare(list[check], list[smallest]) < 0)
                    smallest = check;
            swap(list, smallest, slot);
        }
        return list;
    }
    private void swap(T[] list, int left, int right) {
        if (left != right) {
            T temp = list[left];
            list[left] = list[right];
            list[right] =temp;
        }
    }
}

