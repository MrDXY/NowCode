package 剑指offer算法题;



public class FrogJumpCrazy {
    public static int JumpFloorII(int target) {
        if (target == 0){
            return 1;
        }else if(target == 1){
            return 1;
        }else{
            int pre_pre = 1;
            int pre = 1;
            int cur = pre_pre + pre;
            for (int i = 2; i <= target; i++){
                //System.out.println("当前pre="+String.valueOf(pre)+"  pre_pre= "+String.valueOf(pre_pre));
                cur = pre_pre + pre;
                pre_pre = pre;
                pre = cur;

            }
            return 1;
        }

    }
    public static void main(String[] args){
        System.out.println(Math.pow(2,3));
        System.out.println(JumpFloorII(3));
    }

}
