class Solution {
    public int majorityElement(int[] nums) {
        int count =0;
        int candidate=0;

        for(int elem: nums){
            if(count == 0){
                candidate= elem;
            }

            if(elem == candidate){
                count++;
            }
            else count--;
        }
        return  candidate;
    }
}