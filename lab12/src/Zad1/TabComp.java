package Zad1;

public class TabComp {

    private int [] array;
    public TabComp(int n){
        this.array = new int[n];
    }


    public void makeSet(int x){
        array[x] = x;
    }
    public void union(int x,int y){
        array[findSet(x)] = y;
    }
    public int findSet(int x){
        if(array[x]==0){
            return -1;
        }

        int tmp=x;
        int tmp1=0;
        while (this.array[tmp]!=tmp){
            tmp = this.array[tmp];
        }
        while (this.array[x]!=x){
            tmp1 = this.array[x];
            this.array[x]  =tmp;
            x = tmp1;
        }
        return tmp;

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
