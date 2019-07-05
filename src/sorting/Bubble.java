package sorting;


public class Bubble {

    /**
     * 比较相邻两个元素，若前一个大于后一个，则交换两者的位置，直到最后一个
     * 可以改进的地方：
     * @param arr
     * @return
     */
    public static int[] bubble(int[] arr){
        if(arr == null || arr.length == 0){
            System.out.println("array is null");
            return arr;
        }
        else{
            int temp;
            for(int i = 0; i < arr.length - 1; i++){
                for(int j = i + 1; j < arr.length; j++){
                    if(arr[i] < arr[j]){
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 设置标记flag记录本次循环是否发生交换
     * 若没有发生交换，则表示数组已经是有序状态
     * @param arr 数组
     * @return arr
     */
    public static int[] bubbleBetter(int[] arr){
        if(arr == null || arr.length == 0){
            System.out.println("array is null");
            return arr;
        }
        boolean flag = false;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    //flag记录本次是否发生了交换
                    flag = true;
                }
            }
            if(!flag)
                break;
            else
                flag = false;
        }
        return arr;
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min])
                    min = j;
            int t = arr[i];
            arr[i] = arr[min];
            arr[min] = t;
        }
    }

    public static void main(String[] args){
        int[] a = {2, 3, 1, 7, 5};
//        int[] b = bubble(a);
//        for(int i = 0; i < b.length; i++)
//            System.out.print(b[i] + " ");
//        System.out.println();
        int[] c = bubbleBetter(a);
        for(int i = 0; i < c.length; i++)
            System.out.print(c[i] + " ");

//        selectSort(a);
//        for (int i: a) {
//            System.out.println(i);
//
//        }


    }
}
