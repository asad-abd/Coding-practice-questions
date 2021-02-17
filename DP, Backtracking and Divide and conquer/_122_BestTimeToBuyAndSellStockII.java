class _122_BestTimeToBuyAndSellStockII {
    //buy on someday and sell on the first day we earn profit.
    public int maxProfit(int[] prices) {
        int profitMax=0;
        int min=prices[0];
        if(prices.length<=1)
            return 0;
        for(int i=1;i<prices.length;i++){
            
            if(prices[i]>min){
                profitMax+=prices[i]-min;
                //System.out.println("Min: "+ min+ "\t prices: "+prices[i]);
                min=prices[i];
            }
            else
                min=Math.min(prices[i],min);
            
        }
        return profitMax;
    }
}
