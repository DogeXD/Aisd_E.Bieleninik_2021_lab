package Zad1b;

import Zad1a.Iterators1a.Predicate;
import Zad1b.Iterators1b.*;


public class Students {
    private Student[] students;
    public Students(Student[] s){
        students = s;
    }

    public void wyswietl(){
        ArrayIterator1b<Student> iterator = new ArrayIterator1b<>(students);
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            Student student = (Student) iterator.currentItem();
            System.out.println(student);
        }
    }

    public void wpisz(int nrIndexu,double ocena){
        ArrayIterator1b<Student> iterator = new ArrayIterator1b<>(students);
        for (iterator.first(); !iterator.isDone(); iterator.next()) {
            Student student = (Student) iterator.currentItem();
            if(student.getNrIndexu()==nrIndexu){
                student.setOcena(ocena);
            }
        }
    }

    class PozytywnaOcena1b implements Predicate<Student>{
        @Override
        public boolean accept(Student arg) {
            return arg.getOcena() >= 3.0;
        }
    }

    public void sredniaPoz(){
        ArrayIterator1b<Student> iterator = new ArrayIterator1b<>(students);
        Predicate<Student> predicate = new PozytywnaOcena1b();
        FilterIterator1b<Student> filterIterator  = new FilterIterator1b<>(iterator,predicate);
        int s=0;
        int count=0;
        for (iterator.first(); !iterator.isDone(); iterator.next(),count++) {
            Student student = (Student) iterator.currentItem();
           s+= student.getOcena();
        }
        System.out.println((double) s/count);
    }

    public void wyswietlNegatywnych(){
        ArrayIterator1b<Student> iterator = new ArrayIterator1b<>(students);
        Predicate<Student> predicate = new Predicate<Student>() {
            @Override
            public boolean accept(Student arg) {
                return arg.getOcena()<3.0;
            }
        };
        FilterIterator1b<Student> filterIterator  = new FilterIterator1b<>(iterator,predicate);

        for (filterIterator.first(); !filterIterator.isDone(); filterIterator.next()) {
            Student student = (Student) filterIterator.currentItem();
            System.out.println(student);
        }
    }

    public Student[] przekopiujPoz(){
        ArrayIterator1b<Student> iterator = new ArrayIterator1b<>(students);
        Predicate<Student> predicate = Student -> Student.getOcena()>=3.0;
        FilterIterator1b<Student> filterIterator  = new FilterIterator1b<>(iterator,predicate);

        int count=0;
        for (filterIterator.first(); !filterIterator.isDone(); filterIterator.next()) {
            count++;
        }
        Student[]ar = new Student[count];
        int i=0;

        for (filterIterator.first(); !filterIterator.isDone(); filterIterator.next()) {
            Student student = (Student) iterator.currentItem();
           ar[i]=filterIterator.currentItem();
           i++;
        }
        return ar;

    }
    public Student[] przekopiujNeg(){
        ArrayIterator1b<Student> iterator = new ArrayIterator1b<>(students);
        Predicate<Student> predicate = Student -> Student.getOcena()<3.0;
        FilterIterator1b<Student> filterIterator  = new FilterIterator1b<>(iterator,predicate);

        int count=0;
        for (filterIterator.first(); !filterIterator.isDone(); filterIterator.next()) {
            count++;
        }
        Student[]ar = new Student[count];
        int i=0;

        for (filterIterator.first(); !filterIterator.isDone(); filterIterator.next()) {
            Student student = (Student) iterator.currentItem();
            ar[i]=filterIterator.currentItem();
            i++;
        }
        return ar;

    }

}