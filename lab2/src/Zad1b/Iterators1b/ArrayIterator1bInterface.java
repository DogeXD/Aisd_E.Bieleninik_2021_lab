package Zad1b.Iterators1b;

public interface ArrayIterator1bInterface<T> {
        void first(); // przejście na początek struktury
        void next(); // przejście do przodu do kolejnego elementu
        boolean isDone(); // sprawdzenie, czy iterator wyszedł poza strukturę
        T currentItem(); // odczytanie bieżącego elementu struktury
}
