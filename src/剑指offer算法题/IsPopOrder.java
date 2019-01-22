package 剑指offer算法题;

import java.util.ArrayList;
import java.util.Stack;

public class IsPopOrder {
    public static boolean PopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int curPop = 0; //用来记录此时pop序列的位置
        for (int curPush : pushA) {
            stack.push(curPush);
            while (!stack.isEmpty() && stack.peek() == popA[curPop]) {
                System.out.println(stack.pop());
                curPop++;
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != popA[curPop]) {
                return false;
            }
            System.out.println(popA[curPop]);
            curPop++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
        System.out.println(PopOrder(push, pop));
    }
}