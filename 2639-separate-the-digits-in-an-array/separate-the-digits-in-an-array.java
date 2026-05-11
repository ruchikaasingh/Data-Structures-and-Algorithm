class Solution {
    public int[] separateDigits(int[] nums) {
        int n= nums.length;

        StringBuilder sb= new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(Integer.toString(nums[i])).append("");
        }

        int arr[]= new int[sb.length()];
        for(int i=0; i<sb.length(); i++){
            arr[i]= sb.charAt(i)-'0' ;
        }
        return arr;
    }
}