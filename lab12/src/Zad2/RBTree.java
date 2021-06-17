package Zad2;

public class RBTree {



    private final static boolean RED = true;
    private final static boolean BLACK = false;
    private Node root;
    private class Node{
        int key;
        Node left,right;
        boolean color;

        public Node(int key,  boolean color) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    public void put(int key) {


        root = put(root, key);
        root.color = BLACK;
    }
    private Node put(Node h, int key) {
        if (h == null) return new Node(key, RED);
    if(key<h.key){
            h.left  = put(h.left,  key);
        }
        else if(key>h.key){
            h.right = put(h.right, key);
        }

        if (isRed(h.right) && !isRed(h.left))      h = rotateLeft(h);
        if (isRed(h.left)  &&  isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left)  &&  isRed(h.right))     flipColors(h);


        return h;
    }
    private Node rotateRight(Node h) {
        assert (h != null) && isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        return x;
    }


    private Node rotateLeft(Node h) {
        assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;

        return x;
    }

    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    int COMP=0;
    private Node treeSearch(Node node,int key){
        if(node==null|| key==node.key){
            COMP++;
            return node;
        }
        if(key<node.key){
            COMP++;
            return treeSearch(node.left,key);
        }
        else {
            return treeSearch(node.right,key);
        }
    }
    public Node treeSearch(int key){

        return  treeSearch(root,key);
    }

    private void preOrder(Node root){
        if(root!=null) {
            if(isRed(root)){
                System.out.println(root.key+ " red ");
            }
            else {
                System.out.println(root.key+ " black ");
            }
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void postOrder(Node root){
        if(root!=null) {

            postOrder(root.left);
            postOrder(root.right);
            if(isRed(root)){
                System.out.println(root.key+ " red ");
            }
            else {
                System.out.println(root.key+ " black ");
            }

        }
    }
    private void inOrder(Node root){
        if(root!=null) {
            inOrder(root.left);
            if(isRed(root)){
                System.out.println(root.key+ " red ");
            }
            else {
                System.out.println(root.key+ " black ");
            }
            inOrder(root.right);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    public void postOder(){
        postOrder(root);
    }
    public void inOrder(){
        inOrder(root);
    }

    private void printByLevels(Node root){
        int h = maxDepth(root);
        for (int i =0;i<=h;i++){
            printLevel(root,i);
            System.out.println();
        }
    }

    private void printLevel(Node root , int level){
        if(root==null){
            return;
        }
        if(level==1){
            System.out.printf(String.valueOf(root.key)+" ");
        }
        else if(level>1){
            printLevel(root.left,level-1);
            printLevel(root.right,level-1);
        }
    }
    public void print(){
        printByLevels(root);
    }




    private int maxDepth(Node node){
        if(node==null){
            return 0;
        }
        else {
            int ldepth = maxDepth(node.left);
            int rdepth = maxDepth(node.right);
            if(ldepth>rdepth){
                return ldepth+1;
            }
            else {
                return rdepth+1;
            }
        }
    }

    public void height(){
        System.out.println("wysokosc drzewa "+maxDepth(root));
        System.out.println("wysokosc lewego drzewa "+maxDepth(root.left));
        System.out.println("wysokosc prawego drzewa "+maxDepth(root.right));
    }

    private int countNodes(Node node){
        if(node==null){
            return 0;
        }
        int res=0;
        if(node!=null){
            res++;
        }
        res+=countNodes(node.left)+countNodes(node.right);
        return res;
    }

    public void countNodes(){
        System.out.println("ilosc wezlow drzewa "+countNodes(root));
        System.out.println("ilosc wezlow lewego drzewa "+countNodes(root.left));
        System.out.println("ilosc wezlow prawego drzewa "+countNodes(root.right));
    }

}
