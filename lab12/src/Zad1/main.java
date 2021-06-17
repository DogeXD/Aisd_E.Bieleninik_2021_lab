package Zad1;

public class main {
    public static void main(String [] args){

        System.out.println("\nLas komprsowany\n");
       ForestComp forestComp = new ForestComp();
        forestComp.makeSet(2);
        forestComp.makeSet(5);
        forestComp.makeSet(6);
        forestComp.makeSet(7);
        forestComp.makeSet(8);
        forestComp.print();
        forestComp.union(2,6);
        forestComp.union(7,5 );
        forestComp.print();



        System.out.println("\nLas rownowazony\n");
        ForestRank forestRank = new ForestRank();
        forestRank.makeSet(2);
        forestRank.makeSet(5);
        forestRank.makeSet(6);
        forestRank.makeSet(7);
        forestRank.makeSet(8);
        forestRank.union(2,6);
        forestRank.union(7,5 );



        System.out.println("\nTablica\n");
     Tab tab = new Tab(10);
     tab.makeSet(2);
     tab.makeSet(5);
     tab.makeSet(6);
     tab.makeSet(7);
     tab.makeSet(8);
     tab.union(2,6);
     tab.union(2,5);
     tab.makeSet(1);
     tab.makeSet(0);
     tab.makeSet(9);
     tab.union(1,9);
     tab.union(6,9);
     tab.union(7,5 );
     tab.union(7,8);

     tab.print();


     System.out.println("\nTablica kompresowana\n");
     TabComp tabComp = new TabComp(10);
     tabComp.makeSet(2);
     tabComp.makeSet(5);
     tabComp.makeSet(6);
     tabComp.makeSet(7);
     tabComp.makeSet(8);
     tabComp.union(2,6);
     tabComp.union(2,5);
     tabComp.makeSet(1);
     tabComp.makeSet(0);
     tabComp.makeSet(9);
     tabComp.union(1,9);
     tabComp.union(6,9);
     tabComp.union(7,5 );
     tabComp.union(7,8);
     tabComp.print();




    }



}
