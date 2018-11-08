package 剑指offer算法题;

public class FrogJump {
    public static int JumpFloor(int target) {
        int result = 0;
        int[] two = new int[target/2+1]; //数组用于存放跳2步的次数
        int[] one = new int[target/2+1]; //数组用于存放跳1步的次数
        int[] sum_pace = new int[target/2+1]; //用于统计该种方法下，共需要多少步走完

        for(int i = 0; i < target/2+1; i++){
            two[i] = i;
            one[i] = target-i*2;
            sum_pace[i] = two[i] + one[i];
        }
        for (int j = 0; j < target/2+1; j++){
            result += strangeCircle(sum_pace[j]-two[j]+1, sum_pace[j])/simpleCircle(two[j]);
            System.out.println("第"+String.valueOf(j)+"轮的result和为："+String.valueOf(result));
        }

        return result;
    }
    public static double simpleCircle(int num){//简单的循环计算的阶乘
        double sum=1.0;
        if(num<0){//判断传入数是否为负数
            throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常
        }
        for(int i=1;i<=num;i++){//循环num
            sum *= i;//每循环一次进行乘法运算
        }
        return sum;//返回阶乘的值
    }

    public static double strangeCircle(int start, int end){
        double sum = 1.0;
        for (int i = start; i <= end; i++){
            sum *= i;
        }
        return sum;
    }


    public static void main(String[] args){
        System.out.println("Start");
        System.out.println(simpleCircle(20));
        System.out.println(strangeCircle(5,7));
        System.out.println(JumpFloor(30));
    }
}
