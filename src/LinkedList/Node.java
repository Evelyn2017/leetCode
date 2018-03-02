package LinkedList;

public class Node {
    //数据域
    int value;
    //结点域
    Node next;

    public Node(){

    }

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

    public int getValue(){
        return value;
    }
}

class NodeList{
    Node head;

    public NodeList(){
        this.head = null;
    }

    /**
     * 在头结点前插入一个结点
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
     * 在头结点后插入结点
     */
    public void insertBack(int value){
        Node aNode = new Node(value);
        Node cur = new Node();
        if(head == null){
            head = aNode;
            cur = aNode;
        }

        else{
            aNode.next = cur.next;
            cur.next = aNode;
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

    public Node getHead(){
        return head;
    }

    public void setHead(Node aNode){
        this.head = aNode;
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

        NodeList listb = new NodeList();
        listb.insertBack(1);
        listb.insertBack(2);
        listb.insertBack(3);
        listb.insertBack(4);

        listb.display();

//        System.out.println("delete");
//        list.delete();
//        list.display();
    }
}
