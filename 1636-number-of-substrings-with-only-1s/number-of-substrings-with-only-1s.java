class Solution {
    public int numSub(String s) {
        int mod= (int) 1e9+7;
        int n= s.length();

        int ans=0;
        int count=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1'){
                count++;
            }
            else{
                count=0;
            }
            ans = (ans + count) % mod;
        }
        return ans;
    }
}