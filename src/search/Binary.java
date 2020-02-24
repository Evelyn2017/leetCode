package search;

public class Binary {
    public static void main(String[] args) {

    }

    static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
