package CopyListWithRandomPointer;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        //공간복잡도 O(N)
        /*
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
        */

        //공간복잡도 O(1)
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while(curr != null){
            if(curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        Node dummy = new Node(0);
        Node copyCurr = dummy;
        curr = head;
        while(curr != null){
            copyCurr.next = curr.next;
            copyCurr = curr.next;

            curr.next = curr.next.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}

/*
class Solution {
    public Node copyRandomList(Node head) {
        Node cur=head;
        while(cur!=null){
            Node tmp = new Node(cur.val);
            tmp.next=cur.next;
            cur.next=tmp;
            cur=tmp.next;
        }
        cur=head;
        while(cur!=null){
            if(cur.random != null) cur.next.random=cur.random.next;
            cur=cur.next.next;
        }
        Node dummy=new Node(0);
        Node copy=dummy;
        cur=head;
        while(cur!=null){
            copy.next=cur.next;
            copy=cur.next;

            cur.next=cur.next.next;
            cur=cur.next;
        }
        return dummy.next;
    }
}
*/