import java.util.ArrayList;

public class ListGraph {

    private ArrayList<ArrayList<Integer>>adj;
    public ListGraph(int V){
        this.adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i = 0; i < V; i++)
            this.adj.add(new ArrayList<Integer>());
    }

    public void addNode(){
        this.adj.add(new ArrayList<Integer>());
    }

    public void printGraph()
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nsasiedzi wierzcholka " + i);
            for (int j = 0; j < this.adj.get(i).size(); j++) {
                System.out.print(" -> "+this.adj.get(i).get(j));
            }
            System.out.println();
        }

    }

    public  void addEdge(int u,int v){
        this.adj.get(u).add(v);
        this.adj.get(v).add(u);
    }






}
