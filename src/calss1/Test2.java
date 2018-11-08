package calss1;

public class Test2 {

    public static boolean Find(int target, int [][] array) {
        System.out.println(array.length);
        System.out.println(array[0].length);
        int row = array.length;
        int col = array[0].length;
        int cur_row = 0;
        int cur_col = col-1;
        while (cur_row < row && cur_col >= 0){
            System.out.println("当前的行号为:"+String.valueOf(cur_row)+"   当前列号为:"+String.valueOf(cur_col));
            if (array[cur_row][cur_col] < target){
                if (cur_row == row-1){
                    return false;
                }else{
                    cur_row++;
                }
            }else if(array[cur_row][cur_col] > target){
                if (cur_col == 0){
                    return false;
                }else {
                    cur_col--;
                }
            }else{
                System.out.println("找到了");
                System.out.println(array[cur_row][cur_col]);
                System.out.println(target);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int num = 0;
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("最终的结果为："+String.valueOf(Find(num, array)));
    }
}
