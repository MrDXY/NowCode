package calss1;

import java.util.ArrayList;
import java.util.*;

public class PrintList {

    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        Stack<ListNode> stack = new Stack<ListNode>(); //新建一个存放节点类型的栈；
        ListNode head = listNode;
        while(head != null){
            System.out.println("当前节点value为："+String.valueOf(head.val));
            stack.push(head);
            head = head.next;
        }
        while(!stack.isEmpty()){
            array.add(stack.pop().val);
        }
        return array;
    }


    public static void main(String args[]){
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        System.out.println(printListFromTailToHead(head));
    }
}
