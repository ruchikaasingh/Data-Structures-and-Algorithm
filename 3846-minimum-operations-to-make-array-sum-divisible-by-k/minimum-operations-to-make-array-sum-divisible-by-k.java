class Solution {
    public int minOperations(int[] nums, int k) {
        int sum=0;

        for(int elem: nums){
            sum+= elem;
        }

        int i=1;
        int currsum=0;
        while((i*k % k==0) && (i*k <= sum)){
            currsum= i*k;
            i++;
        }
        return sum-currsum;
    }
}