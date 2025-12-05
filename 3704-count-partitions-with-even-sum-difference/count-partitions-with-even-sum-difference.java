class Solution {
    public int countPartitions(int[] nums) {
        int n= nums.length;
        int totalsum= 0;
        int leftsum=0;
        int count=0;

        for(int elem: nums){
            totalsum+= elem;
        }

        for(int i=0; i<n-1; i++){
            leftsum+=nums[i];
            totalsum= totalsum- nums[i];
            if((totalsum- leftsum)%2==0) count++;
        }
        return count;
    }
}