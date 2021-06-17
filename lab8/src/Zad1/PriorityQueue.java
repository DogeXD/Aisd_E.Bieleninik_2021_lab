package Zad1;

public class PriorityQueue{

    private int []H ;
    static int size = -1;


    public PriorityQueue(int size){
        this.H = new int[size];
    }

    private int parent(int i)
    {
        return (i - 1) / 2;
    }

    private int leftChild(int i)
    {
        return ((2 * i) + 1);
    }


    private int rightChild(int i)
    {
        return ((2 * i) + 2);
    }


    void shiftUp(int i)
    {

        while (i > 0 &&
                this.H[parent(i)] < H[i])
        {

            swap(parent(i), i);


            i = parent(i);
        }
    }

    private void shiftDown(int i)
    {
        int maxIndex = i;

        int l = leftChild(i);

        if (l <= size &&
                H[l] > H[maxIndex])
        {
            maxIndex = l;
        }

        int r = rightChild(i);

        if (r <= size &&
                H[r] > H[maxIndex])
        {
            maxIndex = r;
        }

        if (i != maxIndex)
        {
            swap(i, maxIndex);
            shiftDown(maxIndex);
        }
    }


    public void enqueue(int p)
    {
        size = size + 1;
        H[size] = p;

        shiftUp(size);
    }


    public int dequeue()
    {
        int result = H[0];


        H[0] = H[size];
        size = size - 1;

        shiftDown(0);
        return result;
    }


    public void changePriority(int i,  int p)
    {
        int oldp = H[i];
        H[i] = p;

        if (p > oldp)
        {
            shiftUp(i);
        }
        else
        {
            shiftDown(i);
        }
    }

    private int getMax()
    {
        return this.H[0];
    }


    public void remove(int i)
    {
        this.H[i] = getMax() + 1;


        shiftUp(i);
        dequeue();
    }

    private void swap(int i, int j)
    {
        int temp= H[i];
        H[i] = H[j];
        H[j] = temp;
    }


}
