/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class deleteDuplication {
    public static ListNode deleteDuplication1(ListNode pHead) {
        if(pHead == null)
            return null;
        ListNode temp = new ListNode(-1);
        ListNode cur = temp;
        while (pHead != null) {
            if(pHead.next == null)
                cur.next = new ListNode(pHead.val);
            if(pHead.next != null && pHead.val != pHead.next.val) {
                cur.next = new ListNode(pHead.val);
                cur = cur.next;
            }
            while (pHead.next != null && pHead.val == pHead.next.val) {
                pHead = pHead.next;
            }
            pHead = pHead.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        ListNode l = deleteDuplication1(l1);
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }
}