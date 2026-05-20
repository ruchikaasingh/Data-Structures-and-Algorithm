class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;

        int left[] = new int[n];
        int right[] = new int[n];

        //first and last elements are always valid
        left[0] = 1;
        right[n - 1] = 1;

        //left elems
        for (int i = 1; i < n; i++) {
            boolean isGreater = true;
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) {
                    isGreater = false;
                    break;
                }
            }
            if (isGreater) left[i] = 1;
        }

        // right elems
        for (int i = 0; i < n - 1; i++) {
            boolean isGreater = true;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] <= nums[j]) {
                    isGreater = false;
                    break;
                }
            }
            if (isGreater) right[i] = 1;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (left[i] == 1 || right[i] == 1) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}