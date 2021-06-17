package Zad1;

public class Main {

    public static void main(String[] args) {
        RBTree rbTree = new RBTree();
        rbTree.put(10);
        rbTree.put(14);
        rbTree.put(13);
        rbTree.put(22);
        rbTree.put(17);
        rbTree.put(23);
        System.out.println("inorder");
        rbTree.inOrder();
        System.out.println("postorder");
        rbTree.postOder();
        System.out.println("preorder");
        rbTree.preOrder();

        rbTree.height();
        rbTree.print();
        System.out.println("");
        rbTree.countNodes();


    }

}
