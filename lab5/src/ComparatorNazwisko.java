package Zad1;
//Jakub Samulski 260407
import java.util.Comparator;

public class ComparatorNazwisko implements Comparator<Osoba> {
    @Override
    public int compare(Osoba o1, Osoba o2) {
        return o1.getNazwisko().compareTo(o2.getNazwisko());
    }
}
