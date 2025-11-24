public class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int sum = 0;
        for (int elem : nums) {
            sum = (sum * 2 + elem) % 5;
            ans.add(sum == 0);
        }
        return ans;
    }
}