package tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int height;

    TreeNode(int x) {
        this.val = x;
    }
}

public class BiTree{
    /**
     *
     * @param root 1*23*
     * @return 123
     */
    public List<Integer> preOrderNonRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(! stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }

        return res;
    }

    public List<Integer> preOrderRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            res.add(root.val);
            res.addAll(preOrderRecursive(root.left));
            res.addAll(preOrderRecursive(root.right));
        }
        return res;
    }

    public List<Integer> preOrderMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
//        TreeNode prev;
//        TreeNode cur = root;
        while (root != null) {
            //找到最左叶子结点
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            }
            else{
                TreeNode nextNode = root.left;
                TreeNode prev = nextNode;
                while(prev.right != null)
                    prev = prev.right;
                res.add(root.val);
                prev.right = root.right;
                root = nextNode;
            }
        }
        return res;
    }

    public List<Integer> preOrderMorris1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev;
        while(cur != null) {
            if(cur.left == null) {
                res.add(cur.val);
                cur = cur.right;
            }
            else {
                prev = cur.left;
                while(prev.right != null && prev.right != cur)
                    prev = prev.right;
                if (prev.right == null) {
                    res.add(cur.val);
                    prev.right = cur;
                    cur = cur.left;
                }
                else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public List<Integer> inOrderNonRecursive(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }


    /**
     * Morris 算法中序遍历
     * 1. 如果当前结点的左孩子结点为空，则输出当前结点，并将其右结点当作当前结点
     * 2. 如果当前结点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点
     *      a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
     *      b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
     * @param root root node
     * @return List<>
     */
    public List<Integer> inOrderMorris(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode prev;
        while(cur != null) {
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }
            else{
                prev = cur.left;
                while(prev.right!=null && prev.right!=cur)
                    prev = prev.right;
                if (prev.right == null ) {
                    prev.right = cur;
                    cur = cur.left;
                }
                else {
                    prev.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public List<Integer> LevelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            res.add(node.val);
            if (node.left!=null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
        }
        return res;
    }

    /**
     * get binary tree height
     * @param root root node
     * @return int: height
     */
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.max(leftHeight, rightHeight);
    }

    public void LLRotate(TreeNode root) {
        TreeNode k = root.left;
        root.left = k.right;
        k.right = root;
        root = k;
    }

    public void RRRotate(TreeNode node) {
        TreeNode k = node.right;
        node.right = k.left;
        k.left = node;
        node = k;

    }


    public static void main(String[] args) {

    }

}
