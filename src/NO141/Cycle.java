package NO141;

public class Cycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

class ListNode{
    int value;
    ListNode next;

    public ListNode(){

    }

    public ListNode(int value){
        this.value = value;
        this.next = null;
    }
}
