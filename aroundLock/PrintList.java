import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
public class PrintList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        print(listNode, list);
        return list;
    }
    public ArrayList<Integer> print(ListNode node, ArrayList<Integer> list) {
        if(node == null) {
            return list;
        }
        print(node.next, list);
        list.add(node.val);
        return list;

    }

}
