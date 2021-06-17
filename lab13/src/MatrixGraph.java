import java.util.ArrayList;

public class MatrixGraph {
    private ArrayList<ArrayList<Integer>> adj;
    public MatrixGraph(int V){
        this.adj = new ArrayList<>(V);
        for(int i =0;i<V;i++){
            this.adj.add(new ArrayList<>(V));
            for(int j =0;j<V;j++){
                this.adj.get(i).add(0);
            }
        }
    }


    public void addEdge(int u,int v){
        this.adj.get(u).set(v,1);
        this.adj.get(v).set(u,1);
    }


    public void printMatrix(){
        for(int i =0;i<this.adj.size();i++){
            for(int j=0;j<this.adj.size();j++){
                System.out.print(this.adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void addNode(){
        int size = this.adj.size()+1;

        ArrayList<Integer> temp = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            temp.add(0);
        }

        for (ArrayList<Integer> integers : this.adj) {
            integers.add(0);
        }
        this.adj.add(temp);

    }

}
