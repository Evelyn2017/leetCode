package NO237;

public class DeleteNode {

    public void deleteNode(ListNode node){
        if(node !=null && node.next != null) {
            node.value = node.next.value;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args){
        ListNode a = new ListNode();
        a.Insert(new ListNode(),3);

    }
}

class ListNode{
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public ListNode(){

    }

    public ListNode Insert(ListNode list, int length){
        ListNode head = list;
        for(int i = 0; i<length; i++){
            list.value = i+10;
            list.next = new ListNode();
            list = list.next;
        }
        while(head != null){
            System.out.println(head.value);
            head = head.next;
        }
        //System.out.println("length: " + length);
        return head;
    }
}
