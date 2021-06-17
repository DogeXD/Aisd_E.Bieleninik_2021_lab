package Zad1;

import java.util.ArrayList;

public class ForestComp {
    private class Node{
        int val;
        Node parent;

        public Node(int val){
            this.val = val;
            this.parent = null;
        }
    }
    private ArrayList<Node>list;

    public ForestComp(){
        this.list = new ArrayList<>();
    }
    public void makeSet(int x){
        list.add(new Node(x));
    }

    public Node findSet(int x){
        Node curr;
        for(Node node:list){
            curr = node;
            while (curr!=null){
                if(curr.val==x){
                    while (curr.parent!=null){
                        curr = curr.parent;
                    }
                    return curr;
                }
                curr = curr.parent;
            }
        }
        return null;
    }


    public void compressNode(int x){
        Node curr=null;
        for(Node node:list){
            curr = node;
            while (curr.parent!=null&&curr.val!=x){
                curr=curr.parent;
            }
            if(curr.val == x){
                break;
            }
        }
        Node p = curr;
        while (p.parent!=null){
            p = p.parent;
        }
        if(curr.parent!=null&& curr.parent!=p){
            list.add(curr.parent);
        }
        if(curr.parent!=null){
            curr.parent = p;
        }
    }
    public void union(int x,int y){
        compressNode(x);
        compressNode(y);
        Node nodex = findSet(x);
        Node nodey = findSet(y);
        nodey.parent = nodex;
        list.remove(nodex);
    }

    public void print(){
        System.out.println("Drukowanie");
        for (Node curr : list) {
            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.parent;
            }
            System.out.println();
        }
    }



}
