package Zad1b.Iterators1b;

import Zad1a.Iterators1a.Predicate;

public class FilterIterator1b<T> implements ArrayIterator1bInterface<T> {

    private final ArrayIterator1b iterf;
    private final Predicate pred;

    public FilterIterator1b(ArrayIterator1b iterf, Predicate pred) {
        this.iterf = iterf;
        this.pred = pred;
        iterf.first();
    }

    public void findNextValid() {
        while (!iterf.isDone() && !pred.accept( iterf.currentItem()) )
            iterf.next();
    }

    @Override
    public void first() {
        iterf.first();
        findNextValid();
    }

    @Override
    public void next() {
        iterf.next();
        findNextValid();
    }

    @Override
    public boolean isDone() {
        return iterf.isDone();
    }

    @Override
    public T currentItem() {
        return (T) iterf.currentItem();
    }
}
