class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        
        //skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') i++;
        
        //sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        //convert digits
        long num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            
            //overflow clamp
            if (sign == 1 && num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && -num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            
            i++;
        }
        
        return (int)(sign * num);
    }
}
