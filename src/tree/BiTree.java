package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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
        while (root != null) {
            //找到最左叶子结点
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            }
            else{
                TreeNode nextNode = root.left;
                TreeNode p = nextNode;
                while(p.right != null)
                    p = p.right;
                res.add(root.val);
                p.right = root.right;
                root = nextNode;
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
}
