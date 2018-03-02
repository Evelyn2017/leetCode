package LinkedList;

public class Node {
    //数据域
    int value;
    //结点域
    Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }

    /**
     * 显示方法
     */
    public void display(){
        System.out.print(this.value + " ");
    }
}

class NodeList{
    private Node head;

    public NodeList(){
        this.head = null;
    }

    /**
     * 在头结点后插入一个结点
     */
    public void insert(int value){
        Node aNode = new Node(value);
        if(head == null){
            head = aNode;
        }else{
            aNode.next = head;
            head = aNode;
        }

    }

    /**
     * 删除头结点后的结点
     */
    public Node delete(){
        Node tmp = head;
        head = tmp.next;
        return tmp;
    }

    /**
     *  显示方法
     */

    public void display(){
        Node cur = head;
        while(cur != null){
            cur.display();
            cur = cur.next;
        }
    }
}

class testLinkedList{
    public static void main(String[] args){
        NodeList list = new NodeList();
        list.insert(34);
        list.insert(23);
        list.insert(15);
        list.insert(89);

        list.display();

        System.out.println("delete");
        list.delete();
        list.display();
    }
}
