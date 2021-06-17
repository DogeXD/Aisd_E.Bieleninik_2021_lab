package Zad2.Iterators;

import Zad1b.Iterators1b.ArrayIterator1bInterface;

import java.util.Random;
import java.util.stream.IntStream;


public class ArrayIterator2 implements ArrayIterator1bInterface {

    final int first;
    final int last;
    int current=-1;

    public ArrayIterator2(int min, int max) {

        first =min;
        last= max;
    }

    public void first() { current= first; }
    public void next() {
        current++;
    }
    public boolean isDone() { return current < first || current > last; }

    public Integer currentItem() {
        return current;
    }

}