class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        int rem = (int)(sum % p);
        if (rem == 0) return 0;      // already divisible

        int n = nums.length;
        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, -1);             // prefix remainder 0 at index -1

        int pref = 0;
        int ans = n;

        for (int i = 0; i < n; i++) {
            pref = (pref + nums[i]) % p;

            int target = (pref - rem + p) % p;   // remainder we need
            if (last.containsKey(target)) {
                ans = Math.min(ans, i - last.get(target));
            }

            last.put(pref, i);
        }

        return ans == n ? -1 : ans;
    }
}
