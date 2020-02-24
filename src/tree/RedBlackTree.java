package tree;


class RBTreeNode {
    int val;
    RBTreeNode left;
    RBTreeNode right;
    String color;

    int height;

    public RBTreeNode(int x) {
        this.val = x;
    }

    public int getHeight(RBTreeNode node) {
        if (node == null)
            return 0;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight);
    }

    public int getHeightIter(RBTreeNode node) {
        return 0;
    }

}

public class RedBlackTree {
}

