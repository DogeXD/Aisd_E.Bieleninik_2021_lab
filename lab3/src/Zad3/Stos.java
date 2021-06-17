package Zad3;

import Zad1.ArrayQueue;
import Zad1.EmptyQueueException;
import Zad1.FullQueueException;

public class Stos<T> {
    private ArrayQueue<T> q1;
    private ArrayQueue<T> q2;
    private int currInd;

    public Stos(int size){
        this.currInd = -1;
        q1 = new ArrayQueue<>(size);
        q2 = new ArrayQueue<>(size);
    }

    public void push(T elem) throws FullQueueException, EmptyQueueException {

        q2.enqueue(elem);

        while (!q1.isEmpty()){
            q2.enqueue(q1.first());
            q1.dequeue();
        }
        this.currInd++;
        ArrayQueue<T> q  = q1;
        q1=q2;
        q2=q;

    }

    public T pop(){

        try {
            this.currInd--;
            return q1.dequeue();


        } catch (EmptyQueueException e) {
            e.printStackTrace();
            return null;
        }
    }
    public T top(){
        try {
            return q1.first();
        } catch (EmptyQueueException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean isEmpty(){
        return this.currInd ==-1;
    }

}
