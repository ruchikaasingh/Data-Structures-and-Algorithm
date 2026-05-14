class Solution {
    public boolean isGood(int[] nums) {
        int n= nums.length;

        int max=0;
        for(int elem: nums){
            max= Math.max(max, elem);
        }

        int freq[]= new int[max+1];
        for(int elem: nums){
            freq[elem]++;
        }
        for(int i=1; i<freq.length-1; i++){
            if(freq[i]!=1) return false;
        }
        if(freq[max]!= 2) return false;
        return true;
    }
}