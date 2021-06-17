package Zad1b;


import Zad1a.Student;
import Zad1a.Students;

public class Main {


    public static void main(String[] args){

        Zad1a.Student[] s ={new Zad1a.Student(1,"Samulski","Jakub",5.0),
                new Zad1a.Student(22,"Szpunar","Jan",5.5),
                new Zad1a.Student(24,"Mickiewicz","Adam",2.0)};
        Zad1a.Students students = new Students(s);
        System.out.println("--------wyswietlanie-------");
        students.wyswietl();
        System.out.println("--------zmiana oceny-------");
        students.wpisz(22,4.0);
        System.out.println("--------wyswietlanie-------");
        students.wyswietl();
        System.out.println("--------średnia ocen pozytywnych-------");
        students.sredniaPoz();
        System.out.println("--------wyswietlanie negatywnych-------");
        students.wyswietlNegatywnych();

        //kopiowanie i wyświetlenie
        System.out.println("--------wyswietlanie Pozytywnych kopia-------");
        Zad1a.Student[] poz = students.przekopiujPoz();
        for(Zad1a.Student st:poz){
            System.out.println(st);
        }
        System.out.println("--------wyswietlanie negatywnych kopia-------");
        Zad1a.Student[] neg = students.przekopiujNeg();
        for(Student st:neg){
            System.out.println(st);
        }



    }
}
