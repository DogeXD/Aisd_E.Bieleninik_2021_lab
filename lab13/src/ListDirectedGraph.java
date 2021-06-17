import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ListDirectedGraph {
    private ArrayList<ArrayList<Integer>>adj;

    public ListDirectedGraph(int V){
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

    public void dfsHelper(int v,boolean [] visited){
        visited[v] =true;
        System.out.println(v+ " ");
        for (int n : this.adj.get(v)) {
            if (!visited[n]) {
                dfsHelper(n, visited);
            }
        }
    }

    public void DFS(int v){
        boolean [] visited = new boolean[this.adj.size()];
        dfsHelper(v,visited);

    }






    public void BFS(int s){
        boolean [] visted = new boolean[this.adj.size()];

        LinkedList<Integer> queue = new LinkedList<>();
        visted[s] = true;
        queue.add(s);

        while (queue.size()!=0){
            s = queue.poll();
            System.out.println(s+" ");

            System.out.print("kolejka: ");
            for(Integer i :queue){
                System.out.print(i+" ");
            }
            System.out.print('\n');


            for (int n : this.adj.get(s)) {
                if (!visted[n]) {
                    visted[n] = true;
                    queue.add(n);
                }
            }

        }
    }


    public  void addEdge(int u,int v){
        this.adj.get(u).add(v);
    }

}
