package NO160;

import sun.jvm.hotspot.ui.table.SortHeaderMouseAdapter;

public class Intersection {
    public ListNode getIntersection(ListNode HeadA, ListNode HeadB){
        if(HeadA == null && HeadB == null)
            return null;

        ListNode a = HeadA;
        ListNode b = HeadB;

        while(a != b)
        {
            a = a == null ? HeadB : a.next;
            b = b == null ? HeadA : b.next;
        }
        return a;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);


        for(int i = 2; i < 5; i++){
            a.next = new ListNode(i);
           // System.out.println(a.next.value);
            a = a.next;
        }

    }
}

class ListNode{
    int value;
    ListNode next;

    public ListNode(int value){
        this.value = value;
        this.next = null;
    }
}
