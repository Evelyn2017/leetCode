package prac;

import java.util.Stack;

public class Offer04 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());
        int first = stack2.pop();
        while(!stack2.isEmpty())
            stack1.push(stack2.pop());

        return first;
    }
}

class Node{
    int val;
    Node next;

    public Node(int val){
        this.val = val;
        this.next = null;
    }
}
