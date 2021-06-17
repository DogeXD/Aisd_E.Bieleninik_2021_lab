package Zad1a.Iterators1a;

import Zad1a.Student;

public class NegatywnaOcena implements Predicate<Student> {

    @Override
    public boolean accept(Student arg) {
        return arg.getOcena()<3;
    }
}
