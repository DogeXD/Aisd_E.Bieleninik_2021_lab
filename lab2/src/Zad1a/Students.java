package Zad1a;

import Zad1a.Iterators1a.*;

public class Students {
    private Student [] students;
    public Students(Student [] s){
        students = s;
    }

    public void wyswietl(){
        ArrayIterator<Student> iterator = new ArrayIterator<>(students);

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void wpisz(int nrIndexu,double ocena){
        ArrayIterator<Student> iterator = new ArrayIterator<>(students);

        while (iterator.hasNext()){
            Student s = iterator.next();
            if(s.getNrIndexu()==nrIndexu){
                s.setOcena(ocena);
            }
        }
    }

    public void sredniaPoz(){
        ArrayIterator<Student> iterator = new ArrayIterator<>(students);
        Predicate<Student> predicate = new PozytywnaOcena();
        FilterIterator<Student> filterIterator  = new FilterIterator<>(iterator,predicate);
        int s=0;
        int count=0;
        while(filterIterator.hasNext()){
           s+= filterIterator.next().getOcena();
           count++;
        }
        System.out.println((double) s/count);
    }

    public void wyswietlNegatywnych(){
        ArrayIterator<Student> iterator = new ArrayIterator<>(students);
        Predicate<Student> predicate = new NegatywnaOcena();
        FilterIterator<Student> filterIterator  = new FilterIterator<>(iterator,predicate);

        while (filterIterator.hasNext()){
            System.out.println(filterIterator.next());
        }
    }

    public Student[] przekopiujPoz(){
        ArrayIterator<Student> iterator = new ArrayIterator<>(students);
        Predicate<Student> predicate = new PozytywnaOcena();
        FilterIterator<Student> filterIterator  = new FilterIterator<>(iterator,predicate);

        int count=0;
        while (filterIterator.hasNext()){
            filterIterator.next();
            count++;
        }
        ArrayIterator<Student> iterator2 = new ArrayIterator<>(students);
        FilterIterator<Student> filterIterator2  = new FilterIterator<>(iterator2,predicate);
        Student[]ar = new Student[count];
        int i=0;
        while (filterIterator2.hasNext()){
           ar[i]= filterIterator2.next();
           i++;
        }
        return ar;

    }
    public Student[] przekopiujNeg(){
        ArrayIterator<Student> iterator = new ArrayIterator<>(students);
        Predicate<Student> predicate = new NegatywnaOcena();
        FilterIterator<Student> filterIterator  = new FilterIterator<>(iterator,predicate);

        int count=0;
        while (filterIterator.hasNext()){
            filterIterator.next();
            count++;
        }
        ArrayIterator<Student> iterator2 = new ArrayIterator<>(students);
        FilterIterator<Student> filterIterator2  = new FilterIterator<>(iterator2,predicate);
        Student[]ar = new Student[count];
        int i=0;
        while (filterIterator2.hasNext()){
            ar[i]= filterIterator2.next();
            i++;
        }
        return ar;

    }




}
