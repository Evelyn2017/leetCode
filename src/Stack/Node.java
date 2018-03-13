package Stack;

public class Node {
    int value;
    Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }

    public void display(){
        System.out.println(this.value + " ");
    }
    public int getValue(){
        return this.value;
    }
}
