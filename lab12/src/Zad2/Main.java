package Zad2;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static int testBst(int n){
        BST bst = new BST();
        BST.Node root = null;
        root = bst.insert(root,1);


        ArrayList<Integer> list = new ArrayList<Integer>();


        Random random = new Random();
        for(int i =0;i<n;i++){
            int toAdd = random.nextInt(n*10);
            if(i%5==0){
                list.add(toAdd);
            }
            bst.insert(root,toAdd);
        }

        for(Integer x :list){
            bst.treeSearch(root,x);
        }
        return bst.COMP;

    }

    public static int testRbTree(int n){
        RBTree rbTree  = new RBTree();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for(int i =0;i<n;i++){
            int toAdd = random.nextInt(n*10);
            if(i%5==0){
                list.add(toAdd);
            }
            rbTree.put(toAdd);
        }

        for(Integer x :list){
            rbTree.treeSearch(x);
        }
        return rbTree.COMP;
    }

    public static int testBTree(int n){
        BTree bTree = new BTree(2);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for(int i =0;i<n;i++){
            int toAdd = random.nextInt(n*10);
            if(i%5==0){
                list.add(toAdd);
            }
            bTree.insert(toAdd);
        }

        for(Integer x :list){
            bTree.conatins(x);
        }
        return bTree.COMP;
    }



    public static void main(String[] args){

        float bstSum = 0;
        float RBTreeSum =0;
        float BTreeSum=0;

        int elemCount=10000;
        int tries=10;

        for(int i=0;i<tries;i++){
            bstSum+= testBst(elemCount);
        }
        for(int i=0;i<tries;i++){
            RBTreeSum+= testRbTree(elemCount);
        }
        for(int i=0;i<tries;i++){
            BTreeSum+= testBTree(elemCount);
        }

        bstSum = bstSum /tries;
        RBTreeSum = RBTreeSum /tries;
        BTreeSum = BTreeSum /tries;

        System.out.println(bstSum);
        System.out.println(RBTreeSum);
        System.out.println(BTreeSum);
    }





}
