class Solution {
    public int[] sortByBits(int[] arr) {
        // Convert to Integer[] so comparator works
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(nums, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);
            if (bitA == bitB) {
                return Integer.compare(a, b);
            }
            return Integer.compare(bitA, bitB);
        });

        // Convert back to int[]
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}