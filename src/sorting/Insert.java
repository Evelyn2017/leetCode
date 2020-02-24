package sorting;


public class Insert {
    public static void sort(int[] arr, int n){
        for(int i = 1; i < 0; i++){
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] < arr[i])
                    break;
                if(j != i - 1){
                    int temp = arr[i];
                    int k;
                    for (k = i - 1; k > j; k--)
                        arr[k + 1] = arr[k];
                    //将a[i]放到正确位置上
                    arr[k + 1] = temp;
                }
            }
        }
    }

    public static int[] sort1(int arr[], int n){
        int i, j;
        for (i = 1; i < n; i++)
            if (arr[i] < arr[i - 1])
            {
                int temp = arr[i];
                for (j = i - 1; j >= 0 && arr[j] > temp; j--)
                    arr[j + 1] = arr[j];
                arr[j + 1] = temp;
            }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {3,2,4,7,1,9,0};
        int a[] = sort1 (arr,7);
        for(int i = 0; i < arr.length; i++)
            System.out.print(a[i] + " ");
    }
}
