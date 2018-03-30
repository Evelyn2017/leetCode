package search;

public class Binary {
    public static void main(String[] args) {

    }

    public static int searchBin(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while(low < high){
            mid = (low + high) /2;
            if(arr[mid] == key)
                return mid;
            else if(arr[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return - 1;
    }
}
