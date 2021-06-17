package Zad1;

import java.util.ArrayList;

public class ForestRank {
    private class Node{
        int val;
        int rank;
        Node parent;
        public Node(int val){
            this.val = val;
            this.parent = null;
            this.rank =0;
        }
    }

    private ArrayList<Node> list;

    public ForestRank(){
        this.list = new ArrayList<>();
    }

    public void makeSet(int x){
        list.add(new Node(x));
    }

    public Node findSet(int x){
        for(Node node:list){
            while (node!=null){
                if(node.val==x){
                    while (node.parent!=null){
                        node= node.parent;
                    }
                    return node;
                }
                node = node.parent;
            }
        }
        return null;
    }

    public void union(int x,int y){
        Node nodex = findSet(x);
        Node nodey = findSet(y);
        if(nodex.rank>nodey.rank){
            nodey.parent = nodex;
            list.remove(nodex);
        }
        else {
            nodex.parent = nodey;
            if(nodex.rank==nodey.rank){
                nodey.rank++;
            }
            list.remove(nodey);
        }
    }
    public void print(){
        System.out.println("Drukowanie");
        for (ForestRank.Node curr : list) {
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.parent;
            }
            System.out.println();
        }
    }


}
