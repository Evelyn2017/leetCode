package tree;

import java.util.List;

public class BinaryTree {

    public static void main(String[] args) {
        int[] arr =  {35,17,39,9,28,65,56,87};
        Node root = new Node(arr[0]);
        for(int i = 1; i < arr.length; i++)
            root.insert(root, arr[i]);

        System.out.println("先序");
        preOrder(root);
        System.out.println("\n中序");
        midOrder(root);
    }

    /**
     * 先序遍历
     */
    public static void preOrder(Node root){
        if(root != null){
            System.out.print(root);
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    /**
     * 中序
     */
    public static void midOrder(Node root){
        if(root != null){
            midOrder(root.getLeft());
            System.out.print(root);
            midOrder(root.getRight());
        }
    }

    /**
     * 后序
     */
    public static void postOrder(Node root){
        if(root != null){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root);
        }
    }

    /**
     * 插入
     */
    public static boolean insert(Node root, int val){
        if(root == null){
            root.setValue(val);
            root.setRight(null);
            root.setRight(null);
            return true;
        }
        else if(root.getValue() == val)
            return false;

        else if(val < root.getValue())
            return(insert(root.getLeft(), val));
        else
            return(insert(root.getRight(), val));
    }

    /**
     * 删除
     */
    public static Node delete(Node root, int val){
        if(root == null) return null;
        if(root.getValue() > val)
            root.setRight(delete(root.getRight(), val));
        else if(root.getValue() < val)
            root.setLeft(delete(root.getLeft(), val));
        else{
            //只有左子树或右子树
            if(root.getRight() == null || root.getLeft() == null)
                root = (root.getLeft() != null) ? root.getLeft() : root.getRight();
            else{
                Node cur = root.getRight();
                while(cur.getLeft() != null)
                    cur = cur.getLeft();
                root.setValue(cur.getValue());
                root.setRight(delete(root.getRight(), cur.getValue()));
            }
        }
        return root;
    }
}

/**
 * 二叉树的结点定义
 */
class Node{
    private int value;
    private Node left;
    private Node right;

    public Node(int value){
        this.value = value;
    }

    /**
     * 插入
     * @param root
     * @param val
     */

    public void insert(Node root, int val){
        if(root.getValue() < val){
            if(root.right == null)
                root.right = new Node(val);
            else
                this.insert(root.right, val);
        }
        else{
            if(root.left == null)
                root.left = new Node(val);
            else
                this.insert(root.left, val);
        }

    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void display(){
        System.out.println(this.value + " ");
    }

    public String toString(){
        return String.valueOf(value + " ");
    }
}
