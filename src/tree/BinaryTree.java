package tree;

public class BinaryTree {
    private Node root;

    public BinaryTree(int value){
        root = new Node(value);
        root.left = null;
        root.right = null;
    }

    /**
     * 
     */


}

/**
 * 二叉树的结点定义
 */
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    public void display(){
        System.out.println(this.value + " ");
    }

    public String toString(){
        return String.valueOf(value);
    }
}
