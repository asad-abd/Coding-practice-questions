class _gfg_palindrome_array {
    static boolean check_palindrome(char a[]){
    
        int i=0, j=a.length-1;
        while(i<=j){
            if(a[i]!=a[j]) return false;
            i++;
            j--;
        }
        return true;

    }
    public static int palinArray(int[] a, int n){
       for(int i=0;i<n;i++){
           String s=""+a[i];
           if(!check_palindrome(s.toCharArray())) return 0;
       }
        return 1;
    }
}
