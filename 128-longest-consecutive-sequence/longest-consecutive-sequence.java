import java.util.*;

class Solution {
    class Dsu {
        int[] parent, size;

        public Dsu(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]); // path compression
        }

        public void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        //map number, idx
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        Dsu dsu = new Dsu(n);

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) continue; // avoid duplicate
            map.put(nums[i], i);

            // Union with neighbors if they exist
            if (map.containsKey(nums[i] - 1)) {
                dsu.union(i, map.get(nums[i] - 1));
            }
            if (map.containsKey(nums[i] + 1)) {
                dsu.union(i, map.get(nums[i] + 1));
            }
        }

        //find largest component size
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, dsu.size[dsu.find(i)]);
        }
        return maxLen;
    }
}