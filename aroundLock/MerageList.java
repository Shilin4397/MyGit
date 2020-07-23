/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class MerageList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list2 == null) {
            return list1;
        }
        if(list1 == null) {
            return list2;
        }
        ListNode head = null;
        ListNode end = null;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                if(head == null) {
                    head = list2;
                    end = list2;
                }else{
                    end.next = list2;
                    end = end.next;
                }
                list2 = list2.next;
            }else{
                if(head == null) {
                    head = list1;
                    end = list1;
                }else{
                    end.next = list1;
                    end = end.next;
                }
                list1 = list1.next;
            }
        }
        if(list2 != null) {
            end.next = list2;
        }
        if(list1 != null) {
            end.next = list1;
        }
        return head;
    }

    //方法二
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list2 == null) {
            return list1;
        }
        if(list1 == null) {
            return list2;
        }
        ListNode head = null;
        if(list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        }else {
            head = list2;
            list2 = list2.next;
        }
        head.next = Merge(list1,list2);
        return head;
    }
}
