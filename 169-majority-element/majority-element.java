class Solution {
    public int majorityElement(int[] nums) {
        int n= nums.length;

        HashMap<Integer, Integer> map= new HashMap<>();   //stores number and its freq
        for(int i=0; i<n; i++){
            int count= map.getOrDefault(nums[i], 0)+1;
            map.put(nums[i], count);

            if(count> n/2){
                return nums[i];
            }
        }
        return 0;
    }
}