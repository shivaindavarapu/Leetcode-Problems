class ListNode{
    int val;
    int next;
    public ListNode(){
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode temp = l1;
        ListNode prev = null;
        while(l1 != null && l2 != null){
            int x =(l1.val+l2.val+c);
            l1.val = x%10;
            c = x/10;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1==null){
            prev.next = l2;
            l1 = l2;
        }
        while(l1 != null){
            int x = (l1.val+c);
            l1.val = x%10;
            c = x/10;
            prev = l1;
            l1 = l1.next;
        }
        if(c==1){
            prev.next = new ListNode(1);
        }
        return temp;
    }
}
