import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Zad2 {


    public static void quickSort(Integer[] arr, int low, int high) {

        if (low >= high)
            return;


        int pivot = arr[low + (high - low) / 2];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {

                i++;
            }

            while (arr[j] > pivot) {

                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        // recursively sort two sub parts
        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }




    static void merge(Integer[] arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        Integer[] L = new Integer[n1];
        Integer[] R = new Integer[n2];

        if (n1 >= 0) System.arraycopy(arr, l, L, 0, n1);

        for (int j = 0; j < n2; ++j)
        {
            R[j] = arr[m + 1 + j];

        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];

                i++;
            }
            else {

                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {

            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {

            arr[k] = R[j];
            j++;
            k++;
        }
    }


    static void mergesort(Integer arr[], int l, int r)
    {

        if (l < r) {
            int m =l+ (r-l)/2;


            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);


            merge(arr, l, m, r);
        }
    }




    public static void heapSort(Integer[] arr)
    {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            createHeap(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            createHeap(arr, i, 0);
        }
    }

   
    static void createHeap(Integer[] arr, int n, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 

     
        if (l < n && arr[l] > arr[largest])
            largest = l;

      
        if (r < n && arr[r] > arr[largest])
            largest = r;

       
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            createHeap(arr, n, largest);
        }
    }


    public static void main(String[]args){
            long sum=0;
            for(int j=0;j<10;j++) {

                int[] arr = new Random().ints(1000000, 0, 1000).toArray();
                Integer[] arr2 = new Integer[arr.length];
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = arr[i];
                }
                Arrays.sort(arr2);
                long time1 = System.nanoTime();
               // mergesort(arr2,0,arr2.length-1);
                quickSort(arr2,0,arr2.length-1);
               // System.out.println(Arrays.toString(arr2));
                //heapSort(arr2);
                long time2 = System.nanoTime();
               // System.out.println((time2 - time1) * 0.000001);
                sum+=time2 - time1;
            }
        System.out.println(sum/10 * 0.000001);




    }





}
