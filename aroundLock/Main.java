/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
import java.util.Scanner;
class Node{
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}

public class Main {
    public static Node delete(Node root, int k) {
        if( root.next == null || k < 0)
            return null;
        Node left = root;
        Node right = root;
        while(k > 0 && right.next != null) {
            right = right.next;
            k--;
        }
//        if(k > 0)
//            return null;
        if(right.next == null) {
            root.next = root.next.next;
        }
        while(right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return root.next;
    }

    public static void printNode(Node root) {
        while(root.next != null) {
            System.out.print(root.val+" ");
            root = root.next;
        }
        System.out.print(root.val);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Node root = new Node(-1);
        Node cur = root;
        for(int i = 0; i < n; i++) {
            cur.next = new Node(in.nextInt());
            cur = cur.next;
        }
        if(n < k)
            printNode(root.next);
        Node tmp = delete(root,k);
        printNode(tmp);
    }
}