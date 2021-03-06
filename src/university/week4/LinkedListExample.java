package university.week4;

class ListNode {
    private String data;
    public ListNode link;

    public ListNode() {
        this.data = null;
        this.link = null;
    }

    public ListNode(String data) {
        this.data = data;
        this.link = null;
    }

    public ListNode(String data, ListNode link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return this.data;
    }
}

class LinkedList {
    private ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void insertMiddleNode(ListNode pre, String data) {
        ListNode newNode = new ListNode(data);
        newNode.link = pre.link;
        pre.link = newNode;
    }

    public void insertLastNode(String data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            this.head = newNode;
        } else {
            ListNode temp = head;
            while (temp.link != null) temp = temp.link;
            temp.link = newNode;
        }
    }

    public void deleteMiddleNode(String data) {
        ListNode pre, temp;
        if (head == null) {
            return;
        }
        pre = head;
        temp = head.link;
        while (temp.link != null) {
            if (data.equals(temp.getData())) {
                pre.link = temp.link;
                return;
            } else {
                pre = temp;
                temp = pre.link;
            }
        }
        if (data.equals(temp.getData())) {
            pre.link = null;
        }
    }

    public void deleteLastNode() {
        ListNode pre, temp;
        if (head == null) return;
        if (head.link == null) {
            head = null;
        } else {
            pre = head;
            temp = head.link;
            while (temp.link != null) {
                pre = temp;
                temp = pre.link;
            }
            pre.link = null;
        }
    }

    public ListNode searchNode(String data) {
        ListNode temp = this.head;
        while (temp != null) {
            if (data.equals(temp.getData())) {
                return temp;
            } else {
                temp = temp.link;
            }
        }
        return temp;
    }

    public void reverseList() {
        ListNode next = head;
        ListNode current = null;
        ListNode pre = null;

        while (next != null) {
            pre = current;
            current = next;
            next = next.link;
            current.link = pre;
        }
        head = current;
    }

    public void printList() {
        ListNode temp = this.head;
        System.out.print("L = (");
        while (temp != null) {
            System.out.print(temp.getData());
            temp = temp.link;
            if (temp != null) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList L = new LinkedList();
        System.out.println("(1) ?????? ???????????? ?????? 3??? ??????");
        L.insertLastNode("???");
        L.insertLastNode("???");
        L.insertLastNode("???");
        L.printList();

        System.out.println("(2) ??? ?????? ?????? ??? ?????? ??????");
        ListNode pre = L.searchNode("???");
        if (pre == null) {
            System.out.println("?????? ?????? ?????? ????????? ??????");
        } else {
            L.insertMiddleNode(pre, "???");
            L.printList();
        }

        System.out.println("(3) ?????? ????????? ???????????? ????????? ??????");
        L.reverseList();
        L.printList();

        System.out.println("(4) ????????? ?????? ????????????");
        L.deleteLastNode();
        L.printList();

        System.out.println("(5) ????????? ????????? ????????? ??????");
        L.deleteMiddleNode("???");
        L.printList();
    }
}
