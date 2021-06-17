import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void bubbleSort(Integer [] array){
        int comapres=0;
        int swaps=0;
        for(int i=0;i<array.length;i++){
            for(int j=0;j< array.length-i-1;j++){
                comapres++;
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swaps+=3;
                }
            }
        }
        System.out.println(comapres);
        System.out.println(swaps);
    }

    public static void selectionSort(Integer [] array){
        int comapres=0;
        int swaps=0;
        for(int i=0;i<array.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<array.length;j++){
                comapres++;
                if(array[j]<array[minIndex]){

                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            swaps+=3;
        }
        System.out.println(comapres);
        System.out.println(swaps);
    }

    public static void insertSort(Integer[] list) {
        int compares=0;
        int swaps=0;
        for (int i = 1; i < list.length; ++i) {
            int value = list[i],temp;
            int j=i;

            while(j>0){
                compares++;
                if(value<(temp=list[j - 1])) {
                    list[j] = temp;
                    swaps++;
                    j--;
                }
                else break;
            }

            if(list[j]>value)
                list[j]= value;
        }
        System.out.println("InsertSort");
        System.out.println("Porównania: "+compares);
        System.out.println("Zamiany: "+swaps);

    }



    public static void main(String[] args) {
	 int[] arr = new Random().ints(1024,0,1000).toArray();
	 Integer[] arr2 = new Integer[arr.length];
	 for(int i=0;i<arr2.length;i++){
	     arr2[i] = arr[i];
     }
	 Arrays.sort(arr2);
	 insertSort(arr2);
    }
}
