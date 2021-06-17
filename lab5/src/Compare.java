package Zad1;
//Jakub Samulski 260407
import java.util.Comparator;

public class Compare implements Comparator<Osoba> {

    @Override
    public int compare(Osoba o1, Osoba o2) {
        if(o1.getNazwisko().compareTo(o2.getNazwisko())==0){
            if(o1.getImie().compareTo(o2.getImie())==0){
                return Integer.compare(o1.getRokUrodzenia(),o2.getRokUrodzenia());
            }
            else {
                return o1.getImie().compareTo(o2.getImie());
            }
        }else {
            return o1.getNazwisko().compareTo(o2.getNazwisko());
        }
    }
}
