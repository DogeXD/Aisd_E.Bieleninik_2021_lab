package Zad1;



public class ArrayQueue<T> {
    T[] array;
    int beginIndex;
    int endIndex;

    public ArrayQueue(int size) {
        array=(T[])new Object[size+1];
    }

    public boolean isEmpty() {
        return beginIndex==endIndex;
    }

    public boolean isFull() {
        return beginIndex==(endIndex+1)%array.length;
    }

    public T dequeue() throws EmptyQueueException  {
        if(isEmpty())
            throw new EmptyQueueException();
        T retValue=array[beginIndex++];
        beginIndex%=array.length;
        return retValue;
    }

    public void enqueue(T elem) throws FullQueueException {
        if(isFull())
            throw new FullQueueException();
        array[endIndex++]=elem;
        endIndex%=array.length;
    }

    public int size() {
        return (endIndex+array.length-beginIndex) % array.length;
    }

    public T first() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        return array[beginIndex];
    }

}
