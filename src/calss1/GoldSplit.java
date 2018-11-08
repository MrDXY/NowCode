package calss1;

public class GoldSplit {

    public static int money(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++) { //首先构建小根堆
            heapInsert(arr, i);
        }


        return result;
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] < arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void dropMin2(int[] arr){

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String args[]){
        int arr[] = {30, 10, 20};
        System.out.println(money(arr));

    }
}
