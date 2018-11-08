package 剑指offer算法题;
import java.util.*;

public class StackToQueen {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args){
        System.out.println("Start");
        StackToQueen queen = new StackToQueen();
        queen.push(1);
        System.out.println(queen.pop());
        queen.push(2);
        queen.push(3);
        System.out.println(queen.pop());
    }
}
