package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author evelyn
 * @description 城市建设者 LeetCode 1135
 * @date 2019-09-23 10:45
 **/
public class MST_kruskal {
    /**
     * @param k 城市个数
     * @param a [city1, city2, cost]
     * @return
     */
    int mst_kruskal(int k, int[][] a) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        queue.addAll(Arrays.asList(a));
        int cost = 0;
        int[] pre = new int[k + 1];

        while (! queue.isEmpty()) {
            int[] tmp = queue.poll();
            int parent1 = find(pre, tmp[0]);
            int parent2 = find(pre, tmp[1]);

            if (parent1 != parent2) {
                cost += tmp[2];
                pre[parent2] = parent1;
            }
        }

        // 计算图中连通分量个数，如果为1 则图连通，输出weight
        int count = 0;
        for (int i = 0; i <= k; i++) {
            if (pre[i] == i)
                count += 1;
        }

        return count == 1 ? cost : -1;
    }

    int find(int[] pre, int i) {
        int root = i;
        int tmp;
        while (root != pre[root])
            root = pre[root];
        while (i != root) {
            tmp = pre[i];
            pre[i] = root;
            i = tmp;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
