class Solution {
    public int lastRemaining(int n) {
        int head= 1;
        int diff=1;
        boolean flag= true;
        return sol(head,diff, flag, n);
    }

    public static int sol(int head, int diff, boolean flag, int n){
        if(n==1) return head;

        if(flag== true || n%2!=0) head+= diff;
        return sol(head, diff*2, !flag, n/2);
    }
}