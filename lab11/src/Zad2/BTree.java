package Zad2;
// Searching a key on a B-tree in Java

public class BTree {

    private int T;

    // Node creation
    public class Node {
        int n;
        int[] key = new int[2 * T - 1];
        Node[] child = new Node[2 * T];
        boolean leaf = true;

        public int Find(int k) {
            for (int i = 0; i < this.n; i++) {
                if (this.key[i] == k) {
                    return i;
                }
            }
            return -1;
        };
    }

    public BTree(int t) {
        T = t;
        root = new Node();
        root.n = 0;
        root.leaf = true;
    }

    private Node root;

    // Search key
    private Node search(Node x, int key) {
        int i = 0;
        if (x == null)
            return x;
        for (i = 0; i < x.n; i++) {
            if (key < x.key[i]) {
                break;
            }
            if (key == x.key[i]) {
                return x;
            }
        }
        if (x.leaf) {
            return null;
        } else {
            return search(x.child[i], key);
        }
    }

    // Splitting the node
    private void split(Node x, int pos, Node y) {
        Node z = new Node();
        z.leaf = y.leaf;
        z.n = T - 1;
        if (T - 1 >= 0) System.arraycopy(y.key, T, z.key, 0, T - 1);
        if (!y.leaf) {
            if (T >= 0) System.arraycopy(y.child, T, z.child, 0, T);
        }
        y.n = T - 1;
        if (x.n + 1 - (pos + 1) >= 0) System.arraycopy(x.child, pos + 1, x.child, pos + 1 + 1, x.n + 1 - (pos + 1));
        x.child[pos + 1] = z;

        if (x.n - pos >= 0) System.arraycopy(x.key, pos, x.key, pos + 1, x.n - pos);
        x.key[pos] = y.key[T - 1];
        x.n = x.n + 1;
    }

    public void insert(final int key) {
        Node r = root;
        if (r.n == 2 * T - 1) {
            Node s = new Node();
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
            insertValue(s, key);
        } else {
            insertValue(r, key);
        }
    }
    private void insertValue(Node x, int k) {

        if (x.leaf) {
            int i = 0;
            for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
                x.key[i + 1] = x.key[i];
            }
            x.key[i + 1] = k;
            x.n = x.n + 1;
        } else {
            int i = 0;
            i++;
            Node tmp = x.child[i];
            if (tmp.n == 2 * T - 1) {
                split(x, i, tmp);
                if (k > x.key[i]) {
                    i++;
                }
            }
            insertValue(x.child[i], k);
        }

    }
    public boolean conatins(int k) {
        if (this.search(root, k) != null) {
            return true;
        } else {
            return false;
        }
    }
    public void show() {
        show(root);
    }

    // Display
    private void show(Node x) {
        assert (x == null);
        for (int i = 0; i < x.n; i++) {
            System.out.print(x.key[i] + " ");
        }
        if (!x.leaf) {
            System.out.println();
            for (int i = 0; i < x.n + 1; i++) {
                show(x.child[i]);
            }
        }
    }
    int min=10000000;
    private void min(Node node){
        assert (node==null);
        for(int i=0;i<node.n;i++){
            if(node.key[i]<min){
                min = node.key[i];
            }
        }
        if(!node.leaf){
            for(int i=0;i<node.n+1;i++){
                min(node.child[i]);
            }
        }
    }
    public int min(){
         min(root);
         return min;
    }
    int max = -1;
    public void max(Node node){
        assert node==null;
        for(int i =0;i<node.n;i++){
            if(node.key[i]>max){
                max = node.key[i];
            }
        }
        if(!node.leaf){
            for(int i =0;i<node.n+1;i++){
                max(node.child[i]);
            }
        }
    }
    public int max(){
        max(root);
        return max;
    }


    public static void main(String[] args) {
        BTree b = new BTree(2);
        b.insert(8);
        b.insert(9);
        b.insert(10);
        b.insert(11);
        b.insert(15);
        b.insert(20);
        b.insert(17);
        System.out.println("wyszukiwanie 17");
        System.out.println( b.conatins(8));
        System.out.println("poziomami");
        b.show();
        System.out.println(" ");
        System.out.println("min");
        System.out.println(b.min());
        System.out.println("max");
        System.out.println(b.max());


    }
}