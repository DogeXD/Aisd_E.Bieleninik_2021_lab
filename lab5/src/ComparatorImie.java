package Zad1;
//Jakub Samulski 260407
import java.util.Comparator;

public class ComparatorImie implements Comparator<Osoba> {
    @Override
    public int compare(Osoba o1, Osoba o2) {
        return o1.getImie().compareTo(o2.getImie());
    }
}
