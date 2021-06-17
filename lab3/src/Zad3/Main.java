package Zad3;

import Zad1.EmptyQueueException;
import Zad1.FullQueueException;

public class Main {
    public static void main(String [] args){
        Stos<Integer> s = new Stos<>(4);
        try {
            s.push(3);
            s.push(4);
            s.push(1);
            System.out.println(s.top());
            System.out.println(s.pop());
            s.push(45);
            System.out.println(s.top());
            System.out.println(s.pop());
            System.out.println(s.isEmpty());


        } catch (FullQueueException | EmptyQueueException e) {
            e.printStackTrace();
        }
    }
}
