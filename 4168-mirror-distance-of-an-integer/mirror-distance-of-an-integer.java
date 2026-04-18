class Solution {
    public int mirrorDistance(int n) {
        int dup= n;
        int rev=0;

        while(dup>0){
            int rem= dup%10;
            rev= rev*10+ rem;

            dup= dup/10;
        }

        return Math.abs(n - rev);
    }
}