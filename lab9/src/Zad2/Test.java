package Zad2;

import Zad1.DoubleHash;
import Zad1.LinearHash;
import Zad1.SquareHash;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main (String[] args){
        Random random = new Random();
        LinearHash linearHash = new LinearHash(1000);
        SquareHash squareHash = new SquareHash(1000);
        DoubleHash doubleHash = new DoubleHash(1000);

        ArrayList<Integer>keys = new ArrayList<>();

        for(int i =0;i<900;i++){
            int key = random.nextInt(10000);
            String val = String.valueOf(key);
            linearHash.put(key,val);
            squareHash.put(key,val);
            doubleHash.put(key,val);
            keys.add(key);
        }

        for(int i =0;i<100;i++){
            int randkey = keys.get(random.nextInt(keys.size()));
            linearHash.get(randkey);
            squareHash.get(randkey);
            doubleHash.get(randkey);
        }
        linearHash.wypiszStatystyki();
        squareHash.wypiszStatystyki();
        doubleHash.wypiszStatystyki();



    }


}
