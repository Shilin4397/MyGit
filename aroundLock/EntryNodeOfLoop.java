/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class EntryNodeOfLoop {
    public static ListNode EntryNodeOfLoop1(ListNode pHead) {
//        if(pHead == null || pHead.next == null)
//            return null;
//        ListNode fast = pHead.next;
//        ListNode slow = pHead;
//        while (fast.next != null && fast.next.next != null && fast != slow) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
        if(pHead==null||pHead.next==null)return null;
        ListNode p1=pHead;
        ListNode p2=pHead;
        while(p2!=null&&p2.next!=null)
        {
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2)
            {
                p1=pHead;
                while(p1!=p2)
                {
                    p1=p1.next;
                    p2=p2.next;
                }
                if(p1==p2)return p1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);


        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l2;

        ListNode l = EntryNodeOfLoop1(l1);
        if(l == null){
            System.out.println("null");
        }else {
            System.out.println(l.val);
        }
    }
}
