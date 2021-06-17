package Zad2;

public class BST {
    public class Node{
        int key;
        Node right,left,parent;
        public Node(int key){
            this.key = key;
            this.right=null;
            this.left=null;
            this.parent=null;
        }
    }
    private Node head;

    public Node insert(Node node,int key){
        if(node==null){
            return (new Node(key));
        }
        else {
            if(key<=node.key){
                node.left = insert(node.left,key);
            }
            else {
                node.right = insert(node.right,key);
            }
            return node;

        }
    }
    public void preOrder(Node root){
        if(root!=null) {
            System.out.println(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root){
        if (root!= null){
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }

    public void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.key);
        }
    }
    int COMP=0;
    public Node treeSearch(Node root,int key){

        if(root==null|| key==root.key){
            COMP++;
            return root;
        }
        if(key<root.key){
            COMP++;
            return treeSearch(root.left,key);
        }
        else {
            return treeSearch(root.right,key);
        }
    }

    public int min(Node root){
        Node current = root;
        while (current.left!=null){
            current= current.left;
        }
        System.out.println(current.key);
        return current.key;
    }

    public void max(Node root){
        Node current = root;
        while (current.right!=null){
            current= current.right;
        }
        System.out.println(current.key);
    }

    public int maxDepth(Node node){
        String s = "Wysokosc drzewa to: ";
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
    int countNodes(Node node){
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

    int countLeafs(Node node){
        if(node==null){
            return 0;
        }
        int res=0;
        if(node.left==null&&node.right==null){
            res++;
        }
        res+= countLeafs(node.left)+countLeafs(node.right);
        return res;
    }

    void printByLevels(Node root){
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
            System.out.printf(String.valueOf(root.key));
        }
        else if(level>1){
            printLevel(root.left,level-1);
            printLevel(root.right,level-1);
        }
    }

    Node pre = new Node(-1);
    Node suc = new Node(-1);

    private void preSuc(Node root,int key){
        if(root==null)
            return;
        if(root.key==key){
            if(root.left!=null){
                Node tmp =root.left;
                while (tmp.right!=null){
                    tmp = tmp.right;
                }
                pre = tmp;
            }

            if(root.right!=null){
                Node tmp = root.right;
                while (tmp.left!=null){
                    tmp = tmp.left;
                }
                suc=tmp;
            }
            return;
        }
        if(root.key>key){
            suc=root;
            preSuc(root.left,key);
        }
        else {
            pre=root;
            preSuc(root.right,key);
        }
    }

    public void findPre(Node node,int key){
        preSuc(node,key);
        System.out.println(pre.key);
    }
    public void findSuc(Node node,int key){
        preSuc(node,key);
        System.out.println(suc.key);
    }

    public Node delete(Node root , int key){
        if(root==null){
            return root;
        }
        if(key<root.key){
            root.left = delete(root.left,key);
        }
        else if(key>root.key){
            root.right = delete(root.right,key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if (root.right==null){
                return root.left;
            }
            root.key = min(root.right);
            root.right = delete(root.right,root.key);
        }
        return root;
    }


    static final int COUNT = 10;
    public void print2DUtil(Node root, int space)
    {
        if (root == null)
            return;
        space += COUNT;

        print2DUtil(root.right, space);

        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.key + "\n");


        print2DUtil(root.left, space);
    }


    public  void print2D(Node root)
    {
        print2DUtil(root, 0);
    }



}






