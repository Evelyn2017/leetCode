package Graph;

/**
 * @author evelyn
 * @description TODO
 * @date 2019-08-31 15:13
 **/
public class DGU {
    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * (i + 1);
    }

    void maxHeapify(int[] arr, int size, int i) {
        int l = left(i);
        int r = right(i);
        int largest = -1;
        if (l < size && arr[l] > arr[i])
            largest = l;
        else
            largest = i;
        if (r < size && arr[r] > arr[largest])
            largest = r;
        if (i != largest) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            maxHeapify(arr, size, largest);
        }
    }

    void buildHeap(int[] arr) {
        int last_not_leaf = arr.length / 2 - 1;
        for(int i = last_not_leaf; i >= 0; i--)
            maxHeapify(arr, arr.length, i);
    }

    int[] sort(int[] arr) {
        buildHeap(arr);
        for(int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            maxHeapify(arr, i, 0);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,1,2,6,5};
        DGU d = new DGU();
        arr = d.sort(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
