package Zad1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Pair
{
    int first, second;
    public Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

public class Dijkstra {
    static final int inf =Integer.MAX_VALUE;

    static class Node
    {
        int vertexNumber;
        List<Pair> children;
        Node(int vertexNumber)
        {
            this.vertexNumber = vertexNumber;
            children = new ArrayList<>();
        }

        void add_child(int vNumber, int length)
        {
            Pair p = new Pair(vNumber, length);
            children.add(p);
        }
    }

    static int[] dijkstraDist(List<Node> g,
                              int s, int[] path)
    {


        int[] dist = new int[g.size()];

        boolean[] visited = new boolean[g.size()];
        for(int i = 0; i < g.size(); i++)
        {
            visited[i] = false;
            path[i] = -1;
            dist[i] = inf;
        }
        dist[s] = 0;
        path[s] = -1;
        int current = s;

        Set<Integer> sett = new HashSet<>();
        while (true)
        {
            visited[current] = true;
            for(int i = 0;
                i < g.get(current).children.size();
                i++)
            {
                int v = g.get(current).children.get(i).first;

                if (visited[v])
                    continue;

                sett.add(v);
                int alt = dist[current] +
                        g.get(current).children.get(i).second;

                if (alt < dist[v])
                {
                    dist[v] = alt;
                    path[v] = current;
                }
            }
            sett.remove(current);

            if (sett.isEmpty())
                break;
            int minDist = inf;
            int index = 0;

            for(int a : sett)
            {
                if (dist[a] < minDist)
                {
                    minDist = dist[a];
                    index = a;
                }
            }
            current = index;
        }
        return dist;
    }


    // Driver Code
    public static void main(String[] args)
    {
        List<Node> v = new ArrayList<>();
        int n = 4, s = 0, e = 5;

        // Loop to create the nodes
        for(int i = 0; i < n; i++)
        {
            Node a = new Node(i);
            v.add(a);
        }

        // Creating directed
        // weighted edges
        v.get(0).add_child(1, 1);
        v.get(0).add_child(2, 4);
        v.get(1).add_child(2, 2);
        v.get(1).add_child(3, 6);
        v.get(2).add_child(3, 3);

        int[] path = new int[v.size()];
        int[] dist = dijkstraDist(v, s, path);

        // Loop to print the distance of
        // every node from source vertex
        for(int i = 0; i < dist.length; i++)
        {

            System.out.println("odleglosc od "+i+" do "+s+" wynosi "+ dist[i]);
        }
    }
}

// This code is contributed by sanjeev2552
