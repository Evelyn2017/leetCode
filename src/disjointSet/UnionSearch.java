package disjointSet;

import java.util.PriorityQueue;

/**
 * @author evelyn
 * @description 并查集
 *              初始化
 *              合并
 *              查找
 * @date 2019-09-19 10:12
 **/
public class UnionSearch {
    int[] init(int n) {
        int[] pre = new int[n];
        int[] rank = new int[n];
        for (int i  = 0; i <= n; i++) {
            pre[i] = i;
            rank[i] = 0;
        }
        return pre;
    }

    int find (int[] pre, int i) {
        int root = i;
//        int tmp;
//        while (root != pre[root])
//            root = pre[root];
//        while(i != root) {
//            tmp = pre[root];
//            pre[i] = root;
//            i = tmp;
//        }
        return root;
    }

    void union(int[] pre, int[] rank, int a, int b) {
        link(pre, rank, find(pre, a), find(pre, b));
    }

    void link(int[] pre, int[] rank, int a, int b) {
        if (rank[a] > rank[b])
            pre[b] = a;
        else {
            pre[a] = b;
            if (rank[a] == rank[b])
                rank[b] ++;
        }
    }

}
