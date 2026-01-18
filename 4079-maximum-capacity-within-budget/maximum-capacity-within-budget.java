class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int res = 0;
        int max = 0;
        int [][] dp = new int[n][2];

        for(int i = 0; i<n; i++){
            dp[i][0] = costs[i];
            dp[i][1] = capacity[i];
        }

        Arrays.sort(dp,(x, y) -> x[0] - y[0]);


        int [] pre = new int[n];
        pre[0] = dp[0][1];
        for(int i = 1; i<n; i++){
            pre[i] = Math.max(pre[i-1], dp[i][1]);
        }
        
        for(int i = 0; i<n ; i++){
            if(dp[i][0] < budget){
                res = Math.max(dp[i][1], res);
            }

            int rem = budget - dp[i][0] - 1;

            int l = 0;
            int r = i-1;
            int ind = -1;
            while(l <= r){
                int m = (l+r) / 2;
                if(dp[m][0] <= rem){
                    ind = m;
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            }
            if(ind != -1){
                res = Math.max(res, pre[ind] + dp[i][1]);
            }
                
        }
        return res;
    }
}