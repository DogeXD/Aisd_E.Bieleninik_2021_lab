package Zad2;

import Zad1.Heapsort;

import java.util.Arrays;
import java.util.Random;

public class Main {

    static int compareslin=0;
    static int comparesBin=0;
    static int missedLin=0;
    static int missedBin=0;
    static int hitLin=0;
    static int hitBin=0;

    public static void generate(int [] arr){
        Random random = new Random();
        for(int i=0;i< arr.length;i++){
            arr[i] = random.nextInt(100000);
        }
    }

    public static int linear(int [] arr,int key){

        for (int j : arr) {
            compareslin++;
            if (j == key) {
                hitLin++;
                return j;
            }
            else {
                missedLin++;
            }
        }

        return -1;
    }

    public static int binarySearch(int arr[], int x)
    {


        int l = 0, r = arr.length - 1;

        while (l <= r) {
            comparesBin++;
            int m = l + (r - l) / 2;
            comparesBin++;
            if (arr[m] == x) {
                hitBin++;
                return m;
            }
            else {
                missedBin++;
            }

           comparesBin++;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }


    public static void main(String [] args){
        Random random = new Random();
        int linearSum=0;
        int binarySum=0;
        Heapsort heapsort = new Heapsort();
        // Lekko zmodyfikowalem te metody wyszukiwania zeby zwracaly ilosc porownan zamiast indexu szukanego elementu
        for(int i=0;i<100;i++) {
            int[] arr = new int[100000];
            int key = random.nextInt(100000);
            generate(arr);
            linear(arr, key);
            heapsort.sort(arr);
            binarySearch(arr, key);
        }
        // nie zawsze element jest w tablicy wiec gdyby dzielic trafione przez 100 to wychodzilo by 0
        System.out.println("wyniki dla 100 wyszukiwan   ");
        System.out.println("Porownania liniowe "+compareslin+" chybione "+missedLin+" trafione "+hitLin);
        System.out.println("Porownania binarne "+comparesBin+" chybione "+missedBin+" trafione "+hitBin);



    }
}
