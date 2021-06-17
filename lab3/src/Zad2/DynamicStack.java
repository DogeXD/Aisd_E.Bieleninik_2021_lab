package Zad2;

import java.util.EmptyStackException;
import java.util.Stack;

public class DynamicStack<T> {

    int size ;
    int top;
    T a[];

    public DynamicStack(int size) {
        this.size = size;
        a = (T[])new Object[size];
    }

    boolean isEmpty()
    {
        return (top < 0);
    }

    public void increaseSize(){
        T[] copy = (T[])(new Object[size + size]);
        System.arraycopy(a, 0, copy, 0,top+1);
        size  = size+size;
        a=copy;
    }

    public void decreaseSize(){
        T[] copy = (T[])(new Object[(int)(0.5*size)]);
        System.arraycopy(a, 0, copy, 0,top+1);
        size  = (int)(0.5*size);
        a=copy;
    }



    void push(T x)
    {
        if(top>=(int)(0.75*size)) {

            increaseSize();
            System.out.println("zwiekoszono  rozmiar do "+size);
        }
            a[++top] = x;
    }

    T pop()
    {
        if(top<=(int)(0.25*size)){

            decreaseSize();
            System.out.println("zmniejszono  rozmiar do "+ size);
        }


        if (top < 0) {
           throw new EmptyStackException();
        }
        else {
            T x = a[top--];
            return x;
        }
    }

    T peek()
    {
        if (top < 0) {
          throw new EmptyStackException();
        }
        else {
            T x = a[top];
            return x;
        }
    }
}



