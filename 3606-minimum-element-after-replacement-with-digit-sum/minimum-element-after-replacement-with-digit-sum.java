class Solution {
    public int minElement(int[] nums) {
        int n= nums.length;
        int min= (int)1e4+1;

        for(int i=0; i<n; i++){
            int elem= nums[i];
            int num=0;

            while(elem>0){
                int rem= elem % 10;
                num = rem + num;
                elem /= 10;
            }
            min= Math.min(min, num);        
        }

        return min;
    }
}