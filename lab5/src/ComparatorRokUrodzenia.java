package Zad1;
//Jakub Samulski 260407
import java.util.Comparator;

public class ComparatorRokUrodzenia implements Comparator<Osoba> {
    @Override
    public int compare(Osoba o1, Osoba o2) {
        return Integer.compare(o1.getRokUrodzenia(),o2.getRokUrodzenia());
    }
}
