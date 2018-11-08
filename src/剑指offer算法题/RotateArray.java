package 剑指offer算法题;

import java.util.ArrayList;

import java.util.Arrays;
public class RotateArray {
    public static int minNumberInRotateArray(int [] array) {
        Arrays.sort(array);
        return array[0];
    }
    public static void main(String[] args){
        System.out.println("Start");
        int[] array = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(array));

    }
}
