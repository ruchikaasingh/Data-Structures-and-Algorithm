class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n= nums.length;
        List<String> list= new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        
        int j=0;
        for(int i=0; i<n; i++){
            if(i+1<n && nums[i+1] == nums[i]+1){
                continue;
            }
            else{
                if(i==j){
                    sb.append(nums[j]);
                    list.add(sb.toString());
                }
                else{
                    sb.append(nums[j]).append("->").append(nums[i]);
                    list.add(sb.toString());
                }
                
                j=i+1;
                sb= new StringBuilder();
            }
        }
        return list;
    }
}