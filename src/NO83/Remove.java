package NO83;

class Node{
    int value;
    Node next;

    public Node(int value){
        this.value = value;
    }
}

public class Remove {
    public Node remove(Node head){
        Node res = new Node(0);
        while(head != null){
            if(head.value == res.value)
                head = head.next;
            else{
                res = head;
            }
        }
        return res;
    }
}
