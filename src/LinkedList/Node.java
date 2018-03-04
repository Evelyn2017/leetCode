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
     * 当单链表为空进行插入时，头尾指针均指向插入的结点
     * 当单链表不为空插入时，头指针不变，先定位尾指针，再在尾指针后插入
     */
    public void insertBack(int value){
        Node aNode = new Node(value);
        Node tail = head;
        if(head == null){
            aNode.next = head;
            head = aNode;
        }
        else{
            //寻找尾结点
            while(tail.next != null)
                tail = tail.next;
            //在尾结点插入新结点
            tail.next = aNode;
        }

    }

    /**
     * 单链表反转
     */

    public NodeList reverse(NodeList list){

        NodeList rev = new NodeList();
        while(list.head != null){
            rev.insert(list.head.value);
            head = head.next;
        }
        return rev;
    }

    public Node reverseNode(Node h){
        Node rev = new Node();
        while(h.next != null){
            rev.next = h;
            h = rev;
        }
        return rev;
    }

    public Node reverseCur(Node cur){
        Node pre = null;
        Node nex = null;

        while(cur != null){
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
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


    /**
     * merge
     * @return
     */

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

        NodeList rev = listb.reverse(listb);
        rev.display();

        System.out.println();
        Node a = list.reverseCur(list.head);
        while(a != null){
            System.out.print(a.value + " ");
            a = a.next;
        }

        System.out.println();
        System.out.print(list.mergeTwoList(list.head, listb.head).value);






//        System.out.println("delete");
//        list.delete();
//        list.display();
    }
}
