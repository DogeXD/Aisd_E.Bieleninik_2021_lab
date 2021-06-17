package Zad2.Iterators;

import Zad1a.Iterators1a.Predicate;
import Zad1b.Iterators1b.ArrayIterator1bInterface;


public class FilterIterator2 implements ArrayIterator1bInterface {

        private final ArrayIterator2 iterf;
        private final Predicate pred;

        public FilterIterator2(ArrayIterator2 iterf, Predicate pred) {
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
        public Object currentItem() {
            return (int) iterf.currentItem();
        }
}
