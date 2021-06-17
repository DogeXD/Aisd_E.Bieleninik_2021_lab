package Zad2;

import Zad1a.Iterators1a.Predicate;
import Zad2.Iterators.ArrayIterator2;
import Zad2.Iterators.FilterIterator2;

public class Main {


   public static boolean czyPierwsza(int a){
        if (a <= 1)
            return false;

        else if (a == 2)
            return true;

        else if (a % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(a); i += 2)
        {
            if (a % i == 0)
                return false;
        }
        return true;
    }


    public static void main(String[]args){

        //zwykłe generowanie
        System.out.println("------generowanie--------");
        ArrayIterator2 iterator2=  new ArrayIterator2(1,100);
       for(iterator2.first();!iterator2.isDone();iterator2.next()){
           System.out.println(iterator2.currentItem());
       }
        System.out.println("-----------liczby pierwsze----------");
        //liczby pierwsze
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean accept(Integer arg) {
                return czyPierwsza(arg);
            }
        };
        FilterIterator2 filterIterator2 = new FilterIterator2(iterator2,predicate);
        for(filterIterator2.first();!filterIterator2.isDone();filterIterator2.next()){
            System.out.println(filterIterator2.currentItem());
        }

   }


}
