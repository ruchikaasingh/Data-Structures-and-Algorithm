class Solution{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        fxn(nums, new ArrayList<>(), result);
        return result;
    }

    public void fxn(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                fxn(nums, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}