class Solution {
    public int[] findThePrefixCommonArray(int[] a, int[] b) {
        int n= a.length;
        int m= b.length;

        HashSet<Integer> set= new HashSet<>();
        int ans[]= new int[n];
        int  count=0;

        for(int i=0; i<n; i++){
            set.add(a[i]);

            for(int j=0; j<=i; j++){
                if(set.contains(b[j])){
                    count++;
                }
            }
            ans[i]= count;
        }
        for(int i=n-1; i>0; i--){
            ans[i]= ans[i]- ans[i-1];
        }
        return ans;
    }
}