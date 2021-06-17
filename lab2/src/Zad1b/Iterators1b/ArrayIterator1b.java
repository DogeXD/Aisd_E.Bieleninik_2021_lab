package Zad1b.Iterators1b;

public class ArrayIterator1b<T>implements ArrayIterator1bInterface<T> {

    final T [ ] array;
    final int first;
    final int last;
    int current=-1;

    public ArrayIterator1b(T[] tab) {
        array =tab;
        first =0;
        last= array.length-1;
    }

    public void first() { current= first; }
    public void next() { ++current; }
    public boolean isDone() { return current < first || current > last; }

    public T currentItem() {
        return  array[ current ];
    }

}

