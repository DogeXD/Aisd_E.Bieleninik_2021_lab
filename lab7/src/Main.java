import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    int porownania=0;
    int przypisania=0;

    public  void quickSort(Integer[] arr, int low, int high) {

        if (low >= high)
            return;

        przypisania++;
        int pivot = arr[low + (high - low) / 2];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                porownania++;
                i++;
            }

            while (arr[j] > pivot) {
                porownania++;
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                przypisania+=3;
                i++;
                j--;
            }
        }


        if (low < j)
            quickSort(arr, low, j);

        if (high > i)
            quickSort(arr, i, high);
    }


    void merge(Integer[] arr, int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        Integer[] L = new Integer[n1];
        Integer[] R = new Integer[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
            przypisania++;
        }

        for (int j = 0; j < n2; ++j)
        {
            R[j] = arr[m + 1 + j];
            przypisania++;
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            porownania++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                przypisania++;
                i++;
            }
            else {
                przypisania++;
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            przypisania++;
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            przypisania++;
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    void mergesort(Integer arr[], int l, int r)
    {
        porownania++;
        if (l < r) {
            int m =l+ (r-l)/2;


            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);


            merge(arr, l, m, r);
        }
    }



    public static void main(String[] args) {
        Main main = new Main();

        int[] arr = new Random().ints(1024,0,1000).toArray();
        Integer[] arr2 = new Integer[arr.length];
        for(int i=0;i<arr2.length;i++){
            arr2[i] = arr[i];
        }
        Arrays.sort(arr2);
        main.quickSort(arr2,0, arr2.length-1);

        System.out.println(main.porownania);
        System.out.println(main.przypisania);
        System.out.println( Arrays.toString(arr2));

    }
}
