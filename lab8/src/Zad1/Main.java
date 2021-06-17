package Zad1;

public class Main {

    public static void main(String[] args) {
	PriorityQueue priorityQueue = new PriorityQueue(20);

        priorityQueue.enqueue(45);
        priorityQueue.enqueue(20);
        priorityQueue.enqueue(14);
        priorityQueue.enqueue(12);
        priorityQueue.enqueue(31);
        priorityQueue.enqueue(7);
        priorityQueue.enqueue(11);
        priorityQueue.enqueue(13);
        priorityQueue.enqueue(1);
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        System.out.println(priorityQueue.dequeue());
        int[] arr = {45,20,14,12,31,7,11,13,1};
        Heapsort heapsort = new Heapsort();
        heapsort.sort(arr);
        //bo malejaco
        for(int i=arr.length-1;i>=0;i--){
            System.out.println(arr[i]);
        }






    }
}
