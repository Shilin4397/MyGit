/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//    输入两个链表，找出它们的第一个公共结点。
public class FindFirstPublicNode {
    public int size(ListNode root) {
        int size = 0;
        while(root != null) {
            size++;
            root = root.next;
        }
        return size;
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = size(pHead1);
        int len2 = size(pHead2);
        int k = len1 - len2;
        //让较长的链表先走
        if(k > 0){
            while(k > 0){
                pHead1= pHead1.next;
                k--;
            }
        }else{
            while(k < 0) {
                pHead2 = pHead2.next;
                k++;
            }
        }
        while(pHead1 != null && pHead2 != null) {
            if(pHead1.val == pHead2.val) {
                return pHead1;
            }
            pHead2 = pHead2.next;
            pHead1 = pHead1.next;
        }
        return null;
    }
}
