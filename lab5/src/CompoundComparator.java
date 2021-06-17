package Zad1;
//Jakub Samulski 260407
import java.util.ArrayList;
import java.util.Comparator;

public class CompoundComparator<T> implements Comparator<T> {


    private final ArrayList<Object> _comparators =new ArrayList<Object>();
    public void addComparator(Comparator<T> comparator)
    {
        _comparators.add(comparator);
    }

    public int compare(T left, T right) throws ClassCastException {
        int result = 0;
        for (Object obj:_comparators){
            Comparator<T> comp=(Comparator<T>)obj;
            result=comp.compare(left, right);
            if(result!=0) break;
        }
        return result;
    }
}
