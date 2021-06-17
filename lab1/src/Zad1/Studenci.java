package Zad1;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Studenci {
    private ArrayList<Student> students;

    public Studenci() {
        this.students = new ArrayList<>();
    }

    public void wczytaj() {
        File f1 = new File("src/Zad1/Dane.txt");

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(f1))) {
            bufferedReader.readLine(); // naglowek
            String line = bufferedReader.readLine();

            while (line!= null){
                String [] lines = line.split(" ");
                students.add(new Student(Integer.parseInt(lines[0]),lines[1],lines[2],Double.parseDouble(lines[3])));
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } ;
    }

    public void wyswietl(){
        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("");
    }

    public void zmienOcene(String nazwisko,String imie,Double ocena){
        System.out.println("------Zmiana Oceny----------");
        ListIterator<Student> it = students.listIterator();
        boolean zmieniono=false;

        while (it.hasNext()){
            Student s = it.next();
            if(s.getNazwisko().equals(nazwisko)&&s.getImie().equals(imie)){
               s.setOcena(ocena);
               it.set(s);
               zmieniono = true;
            }
        }
        if(!zmieniono){
            System.out.println("Nie ma takiego studenta");
        }
        System.out.println();
    }

    public void sredniaOcenPozytywnych(){
        System.out.println("-------Srednia--------");
        double suma=0;
        int licznik=0;

        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
           Student s = it.next();
           if(s.getOcena()>=3){
               suma+= s.getOcena();
               licznik++;
           }
        }
        double srednia = suma/licznik;
        System.out.println("Srednia= "+srednia);
        System.out.println("");
    }

    public void nieZaliczyli(){
        System.out.println("------Nie zaliczyli----------");
        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
           Student s = it.next();
           if(s.getOcena()<3){
               System.out.println(s);
           }
        }
        System.out.println("");
    }


    public void zapisz()  {
        File f2 = new File("src/Zad1/Dane2.txt");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f2))){
            bufferedWriter.write("numer indeksu, nazwisko, imię, ocena z AiSD"+'\n');//naglowek
            Iterator<Student> it = students.iterator();
            while (it.hasNext()){
                bufferedWriter.write(it.next().toString()+'\n');
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ;
    }
}
