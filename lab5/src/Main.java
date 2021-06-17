package Zad1;

import java.util.Arrays;
//Jakub Samulski 260407
public class Main {

    public static void print(Osoba[] os){
        for(Osoba o:os){
            System.out.println(o);
        }
    }

    public static void main(String[] args){
        Osoba [] osoby ={new Osoba("Mickiewicz","Adam",1880),
                        new Osoba("Mickiewicz", "Andrzej",2004),
                        new Osoba("Starowski","Adam",1996),
                        new Osoba("Adamski","Adam",1968),
                        new Osoba("Bonaparte","Napoleon",1880)};
        System.out.println("Lista bez sortowania"+'\n');
        print(osoby);

        System.out.println("sortowanie wg nazwiska"+'\n');
        ComparatorNazwisko comparatorNazwisko = new ComparatorNazwisko();
        Buble<Osoba>bubleNaz = new Buble<>(comparatorNazwisko);
        osoby = bubleNaz.sort(osoby);
        print(osoby);

        System.out.println("sortowanie wg imienia"+'\n');
        ComparatorImie comparatorImie = new ComparatorImie();
        Insert<Osoba>insertImie = new Insert<>(comparatorImie);
        osoby = insertImie.sort(osoby);
        print(osoby);

        System.out.println("sortowanie wg roku"+'\n');
        ComparatorRokUrodzenia comparatorRokUrodzenia = new ComparatorRokUrodzenia();
        Select<Osoba> selectRok = new Select<>(comparatorRokUrodzenia);
        osoby = selectRok.sort(osoby);
        print(osoby);


        System.out.println("sortowanie wg komparatora zlozonego"+'\n');
        CompoundComparator<Osoba> cc = new CompoundComparator<>();
        cc.addComparator(comparatorNazwisko);
        cc.addComparator(comparatorImie);
        cc.addComparator(comparatorRokUrodzenia);
        Buble<Osoba> bublecc = new Buble<>(cc);
        osoby = bublecc.sort(osoby);
        print(osoby);


        System.out.println("sortowanie wg zlozonej metody compare "+'\n');
        Compare compare = new Compare();
        Select<Osoba>selectCompare = new Select<>(compare);
        osoby = selectCompare.sort(osoby);
        print(osoby);


    }
}
