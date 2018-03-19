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
        Stack<Integer> res = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        ListNode temp = listNode;
        while(temp.next != null){
            res.push(temp.val);
            temp = temp.next;
        }

        while(!res.empty()){
            result.add(res.pop());
        }
        return result;
    }

}
