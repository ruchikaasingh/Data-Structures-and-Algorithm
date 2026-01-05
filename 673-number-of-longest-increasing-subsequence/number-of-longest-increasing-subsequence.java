import java.util.*;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] cnt = new int[n]; //no of lis from 0 to i

        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev]) {

                    if (len[prev] + 1 > len[i]) {
                        len[i] = len[prev] + 1;
                        cnt[i] = cnt[prev];
                    } 
                    else if (len[prev] + 1 == len[i]) {
                        cnt[i] += cnt[prev];
                    }
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                ans += cnt[i];
            }
        }

        return ans;
    }
}
