package coding_interview;

/**
 * @author evelyn
 * @description TODO
 * @date 2019-09-25 21:53
 **/
public class Remove {
    private static ListNode remove(ListNode node) {
        ListNode cur = node;
        ListNode p = node;
        while (p != null) {
            p = p.next;
            while (p != null && cur.val == p.val)
                p = p.next;
            cur.next = p;
            cur = p;
        }
        return node;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 5};
        ListNode head = new ListNode(arr[0]);
        ListNode nxt;
        ListNode cur = head;
        for (int i1 : arr) {
            nxt = new ListNode(i1);
            cur.next = nxt;
            cur = cur.next;
        }
        head = remove(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
