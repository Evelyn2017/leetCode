package NO21;

class Node{
    int value;
    Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }
}

public class Merge {
    public Node mergeTwoList(Node h1, Node h2){
        Node res = new Node(0);
        while(h1 != null && h2 != null){
            if(h1.value <= h2.value){
                res = h1;
                res = res.next;
                h1 = h1.next;
            }
            else{
                res = h2;
                res = res.next;
                h2 = h2.next;
            }
        }
        if(h1 == null)
            res.next = h1;
        else
            res.next = h2;
        return res;
    }

    public Node merge(Node l1, Node l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.value < l2.value){
            l1.next = merge(l1.next, l2);
            return l1;
        } else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args){

    }
}
