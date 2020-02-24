package coding_interview;

import java.util.Stack;

/**
 * @author evelyn
 * @description TODO
 * @date 2019-09-29 09:53
 **/
public class Prac {
    TreeNode lowestParent(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = root.val > p.val ? root.left : root.right;
        return root;
    }

    ListNode removeDup (ListNode head) {
        ListNode node = head;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            while (p != null && p.val == node.val)
                p = p.next;
            node.next = p;
            node = node.next;
        }
        return head;
    }

    boolean dupArray(int[] arr) {
        int dup;
        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    dup = arr[i];
                    return true;
                }
                swap(arr, i, arr[i]);
            }
        }
        return false;
    }

    void swap (int[] arr, int i, int j) {
        int t = arr[i];
        arr[i]  = arr[j];
        arr[j] = t;
    }

    /**
     *
     * @param a a
     * @param b b
     */
    void swap(int a, int b) {
        a = a^b;
        b = a^b;
        a = a^b;
    }

    boolean findIn2DArray(int[][] arr, int target) {
        int row = arr.length;
        int col = arr[0].length;
        int r = 0;
        int c = col - 1;//从右上角开始查找
        while (r <= row - 1 && c >= 0) {
            if (target == arr[r][c])
                return true;
            else if (target > arr[r][c])
                r++;
            else
                c--;
        }
        return false;
    }

    String replace20(StringBuffer str) {
        int l1 = str.length() - 1;
        for (int i = 0; i <= l1 ; i++) {
            if (str.charAt(i) == ' ')
                str.append(" ");
        }
        int l2 = str.length() - 1;
        while (l1 >= 0 && l2 > l1) {
            char c = str.charAt(l1);
            l1 -- ;
            if (c == ' ') {
                str.setCharAt(l2--, '0');
                str.setCharAt(l2--, '2');
                str.setCharAt(l2--, '%');
            } else
                str.setCharAt(l2--, c);
        }
        return str.toString();
    }

    int minInRotatedArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int m = low + (high - low) / 2;
            if (arr[m] <= arr[high])
                high = m;
            else
                low = m + 1;
        }
        return arr[low];
    }

    int jumpStep(int n) {
        if (n <= 2)
            return n;
        int fn1 = 1;
        int fn2 = 2;
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = fn1 + fn2;
            fn1 = fn2;
            fn2 = res;
        }
        return res;
    }

    int cutRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }

    ListNode lastK(ListNode head, int k) {
        ListNode node = head;
        while (node != null && k-- > 0)
            node = node.next;
        if (k > 0)
            return null;
        ListNode p = head;
        while (node != null) {
            node = node.next;
            p = p.next;
        }
        return p;
    }

    ListNode entryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    boolean hasCycle (ListNode head) {
        if (head == null)
            return false;
        ListNode l1 = head;
        ListNode l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2)
                return true;
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
        }
        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }

    boolean isStackSeq(int[] pushSeq, int[] popSeq) {
        int n = pushSeq.length;
        Stack<Integer> s = new Stack<>();
        for (int pushIndex = 0, popIndex = 0; pushIndex <n; pushIndex ++) {
            s.push(pushSeq[pushIndex]);
            while (popIndex < n && !s.isEmpty() && s.peek() == popSeq[popIndex]) {
                s.pop();
                popIndex ++;
            }
        }
        return s.isEmpty();
    }

    TreeNode flat(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre;
        while (cur != null) {
            if (cur.left != null) {
                pre = cur.left;
                while (pre.right != null)
                    pre = pre.right;
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.left;
        }
        return cur;
    }

    int maxSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum <= 0 ? arr[i] : sum + arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    // fn = max(a[i], dp[i - 1] + a[i])
    int maxSumDP(int[] arr) {
        int arrLength = arr.length;
        int max = Integer.MAX_VALUE;
        int[] fn = new int[arrLength];
        fn[0] = arr[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < arrLength; i++) {
            fn[i] = Integer.max(fn[ i - 1] + arr[i], arr[i]);
            res = Integer.max(res, fn[i]);
        }

        return res;

    }

    TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }

    boolean isSubSequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }

    //dp[i] = max(dp[i - 2] + arr[i], dp[i - 1])
    int rob(int[] arr) {
        int pre2 = 0;
        int pre1 = 0;
        for (int i = 0; i < arr.length; i++) {
            int cur = Math.max(pre2 + arr[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    String longestCommonSubSeq(String s, String t) {
       return null;
    }

    ListNode getIntersection(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l2 != l2) {
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headB : l2.next;
        }
        return l1;
    }

    boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        cut(head, slow);
        return isSame(head, reverse1(slow));
    }

    boolean isSame(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val)
                return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    void cut (ListNode head, ListNode cutNode) {
        while (head.next != cutNode)
            head = head.next;
        head.next = null;
    }

    ListNode reverse1(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode () {}
}
