package Zad1;

public class Main {
    public static void main(String[] args)  {
        ArrayQueue<Integer>q = new ArrayQueue<>(3);

        try {
            //wyjatek1
            q.dequeue();
        } catch (EmptyQueueException e) {
            e.printStackTrace();
        }


        try {
            q.enqueue(3);
            q.enqueue(5);

            System.out.println(q.dequeue());
            System.out.println(q.dequeue());

            q.enqueue(1);
            q.enqueue(1);
            q.enqueue(1);
            q.enqueue(1);
        } catch (FullQueueException | EmptyQueueException e) {
            e.printStackTrace();
        }



    }


}
