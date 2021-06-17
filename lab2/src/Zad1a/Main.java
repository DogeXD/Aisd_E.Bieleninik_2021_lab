package Zad1a;

public class Main {

    public static void main(String[] args){

        Student[] s ={new Student(1,"Samulski","Jakub",5.0),
                new Student(22,"Szpunar","Jan",5.5),
                new Student(24,"Mickiewicz","Adam",2.0)};
        Students students = new Students(s);
        students.wyswietl();
        students.wpisz(22,4.0);
        students.wyswietl();
        students.sredniaPoz();
        students.wyswietlNegatywnych();

        Student[] poz = students.przekopiujPoz();
        for(Student st:poz){
            System.out.println(st);
        }


        Student[] neg = students.przekopiujNeg();
        for(Student st:neg){
            System.out.println(st);
        }


    }

}
