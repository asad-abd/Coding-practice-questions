public class _338_CountingBits {
    //O(n)
    //IMP JAVA NOTE: Since == has higher precedence than &/^, (i-1) == 0 will be evaluated first and will result in boolean!!
    public int[] countBits(int n) {
        int ans[] = new int[n + 1];
        //1(binary) -> 1(binary 1 count)
        //10 -> 1
        //11 -> 2
        //100 -> 1
        //101 -> 2
        //110 -> 2
        //111 -> 3
        //1000 -> 1
        //notice how 111 has a subset of 11 and 110 has a subset of 10
        //overlapping!!
        int pow2 = 1; //2^0
        for(int i = 1; i <= n; i ++){
            if((i&(i - 1)) == 0) pow2 = i;
            //power of 2 <= i
            ans[i] = i / pow2 + ans[i % pow2];
        }
        return ans;
    }

    //trivial O(nlogn) - 9 min to type
    public int count1s(String S){
        int count = 0;
        char s[] = S.toCharArray();
        for(int i = 0; i < s.length; i ++){
            if(s[i] == '1')
                count ++;
        }
        return count;
    }
    public int help(int n){
        StringBuilder str = new StringBuilder();
        while(n > 0){
            str.append(n % 2);
            n = n / 2;
        }
        //System.out.println(str.reverse().toString());
        return count1s(str.reverse().toString());
    }
    public int[] countBits(int n) {
        int ans[] = new int[n + 1];
        for(int i = 1; i <= n; i ++){
            ans[i] = help(i);
        }
        return ans;
    }
}
