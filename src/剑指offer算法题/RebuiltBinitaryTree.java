package 剑指offer算法题;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public class RebuiltBinitaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in, TreeNode head) {
        if (pre.length == 0){ //终止条件，序列长度为0
            return null;
        }
        head.val = pre[0];
        int root = 0;
        for (int i = 0; i < in.length; i++){ //找到中序遍历中，根节点的位置
            if (in[i] == pre[0]){
                root = i;
                break;
            }
        }
        if (root == 0){ //中序根节点左边没有数字，没有左子树
            head.left = null;
        }else{
            head.left = new TreeNode(pre[1]); //如果有左子树，前序遍历root节点的下一个遍历节点一定是左子树最高节点；
        }

        if (root == (in.length-1)){ //中序根节点右边没有数字，没有右子树
            head.right = null;
        }else{
            head.right = new TreeNode(pre[root+1]);
        }
        int[] left_pre = new int[root];
        int[] right_pre = new int[pre.length-root-1];
        int[] left_in = new int[root];
        int[] right_in = new int[in.length-root-1];
        System.arraycopy(pre, 1, left_pre, 0, left_pre.length);
        System.arraycopy(pre, root+1, right_pre, 0, right_pre.length);
        System.arraycopy(in, 0, left_in, 0, left_in.length);
        System.arraycopy(in, root+1, right_in, 0, right_in.length);
        reConstructBinaryTree(left_pre, left_in, head.left);
        reConstructBinaryTree(right_pre, right_in, head.right);
        return head;
    }


    public static void main(String args[]){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode head = new TreeNode(pre[0]);
        TreeNode result = reConstructBinaryTree(pre, in, head);
        System.out.println(result.left.val);
        System.out.println(result.left.left.val);
        System.out.println(result.left.left.right.val);
        System.out.println(result.right.left.val);
        System.out.println(result.right.right.val);
    }

}

