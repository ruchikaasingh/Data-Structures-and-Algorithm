class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n == 0) return 0;

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);  //width inc
            }
            return Integer.compare(b[1], a[1]);    // height decr
        });

        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(envelopes[0][1]);

        for (int i = 1; i < n; i++) {
            int h = envelopes[i][1];

            if (h > tmp.get(tmp.size() - 1)) {
                tmp.add(h);
            } else {
                int idx = lowerBound(tmp, h);
                tmp.set(idx, h);
            }
        }

        return tmp.size();
    }

    private int lowerBound(ArrayList<Integer> list, int target) {
        int l = 0, r = list.size() - 1;
        int ans = list.size();

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}