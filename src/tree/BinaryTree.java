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
