import java.util.*;

public class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);  // Sort to handle duplicates
        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            ans.add(perm);
            return;
        }
        boolean[] used = new boolean[21]; // range adjustments for duplicates
        for (int i = start; i < nums.length; i++) {
            if (!used[nums[i] + 10]) {  // +10 to handle negative values
                used[nums[i] + 10] = true;
                swap(nums, start, i);
                backtrack(nums, start + 1);
                swap(nums, start, i); // backtrack
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
