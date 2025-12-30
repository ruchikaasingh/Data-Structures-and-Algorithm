class Solution {
    public boolean isPalindrome(String s) 
    {
        //filter the string using sb functions
        StringBuilder sb= new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }

        int left = 0, right = sb.length() - 1; 
        
        while (left < right) {                     
            if (sb.charAt(left++) != sb.charAt(right--)) return false;
        }
        return true;
    }
}
