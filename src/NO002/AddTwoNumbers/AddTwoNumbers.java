package NO002.AddTwoNumbers;

public class AddTwoNumbers {
    public static void main(String[] args){
       IntList alist = new IntList(1);
       alist.next = new IntList(2);
       while(alist != null){
           System.out.println(alist.getNum());
           alist = alist.next;
       }

    }
}

class IntList{
    private  int num;
    IntList next = null;

    public IntList(int num){
        this.num  = num;
    }

    public int getNum() {
        return num;
    }
}
