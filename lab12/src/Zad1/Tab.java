package Zad1;

public class Tab {
    private int [] array;

    public Tab(int n){
        this.array = new int[n];
    }
    public void makeSet(int x){
        this.array[x] = x;
    }
    public void union(int x,int y){
        int val = findSet(x);
        this.array[val] = y;
    }

    public int findSet(int x){
        if(array[x]==0){
            return -1;
        }
        while (array[x]!=x){
            x = array[x];
        }
        return x;
    }
    public void print(){
        System.out.println("Drukowanie ");
        for(int i=1 ; i<array.length; i ++ ) {
            if (array[i]==0) continue;

            int temp = i;

            while (array[temp]!=temp) {
                System.out.print(temp+ " ");
                temp=array[temp];
            }
            System.out.print(temp);
            System.out.println();
        }
    }



}
