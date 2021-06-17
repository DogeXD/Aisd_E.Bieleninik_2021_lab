package Zad1;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args){
        BST tree = new BST();
        BST.Node root = null;
        root  =tree.insert(root,4);
        tree.insert(root, 2);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 6);
        tree.insert(root, 5);
        System.out.println("Wartosc minimalna");
        tree.min(root);
        System.out.println("Wartosc maksymalna");
        tree.max(root);
        System.out.println("Wysokosc drzewa to: "+tree.maxDepth(root));
        System.out.println("ilosc wezłow "+tree.countNodes(root));
        System.out.println("ilosc lisci "+tree.countLeafs(root));
        System.out.println("Wypisanie poziomami");
        tree.printByLevels(root);
        System.out.println();
        System.out.println("Poprzednik 2");
        tree.findPre(root,2);
        System.out.println("Nastepnik 2");
        tree.findSuc(root,2);
        System.out.println("usuniecie wezla z kluczem 2");
        root  = tree.delete(root,2);
        System.out.println("Wypisanie poziomami");
        tree.printByLevels(root);
        System.out.println("narysowanie ");
        tree.print2D(root);

    }
}
