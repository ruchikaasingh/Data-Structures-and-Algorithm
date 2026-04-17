class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;

        int maxprofit=0;
        int minprice= Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(minprice> prices[i]){
                minprice= prices[i];
            }
            maxprofit= Math.max(maxprofit, prices[i]- minprice);
        }
        return (maxprofit==0)? 0: maxprofit;    
    }
}