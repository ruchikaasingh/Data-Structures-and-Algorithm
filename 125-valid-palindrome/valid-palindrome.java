class Solution {
    public boolean isPalindrome(String s) {
        if (s.length()==1) return true;
        String clean= s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int left=0;
        int right= clean.length()-1;
        while(left<right){
            if (clean.charAt(left)== clean.charAt(right)){
                left++;
                right--;
            }
            else return false;
        }
        return true;
    }
}