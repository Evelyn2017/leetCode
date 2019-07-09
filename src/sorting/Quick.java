package sorting;

public class Quick {

    /**
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] arr, int low, int high){
        //选择基准点
        int key = arr[low];
        //若两个指针相遇，则数组达到有序状态
        while(low < high){
            while(arr[high] >= key && high > low){
                high--;
            }
            arr[low] = arr[high];
            while(arr[low] <= key && high > low ){
                low ++;
            }
            arr[high] = arr[low];
        }
        arr[high] = key;
        return high;
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low > high)
            return;
        int index = partition(arr, low, high);
        quickSort(arr, low, index - 1 );
        quickSort(arr, index + 1, high);
    }

    public static void sort(int[] arr, int low, int high){

    }

    public static void main(String[] args){
         int[] arr = {7,4,3,1,6};
         quickSort(arr, 0, 4);
         for(int i = 0; i < arr.length; i++)
             System.out.print(arr[i] + " ");
//        String a = new StringBuffer("123");
//        String b = a;
//        System.out.println(a==b);
    }
}
