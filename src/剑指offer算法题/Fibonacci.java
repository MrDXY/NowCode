package 剑指offer算法题;

public class Fibonacci {
    public static int Fibonacci1(int n){
        if (n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            int pre_pre = 0;
            int pre = 1;
            int cur = pre_pre + pre;
            for (int i = 2; i <= n; i++){
                //System.out.println("当前pre="+String.valueOf(pre)+"  pre_pre= "+String.valueOf(pre_pre));
                cur = pre_pre + pre;
                pre_pre = pre;
                pre = cur;

            }
            return cur;
        }
    }

    public static void main(String[] args){
        System.out.println("Start");
        System.out.println(Fibonacci1(12));
    }
}
