package prac;

import java.util.ArrayList;
import java.util.Stack;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}

public class Offer03 {
    public ArrayList<Integer> printList(ListNode listNode){
        Stack<ListNode> res = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        while(listNode.next != null){
            res.push(listNode);
            listNode = listNode.next;
        }

        while(!res.empty()){
            result.add(res.pop().val);
        }
        return result;
    }


}
