class _647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        //Have 2 pointers, left and right, move them in opposite directions from the pivot and increment count for matching characters.
        int n=s.length(), count=0;
        int left, right;
        //for odd length
        for(int pivot=0;pivot<n;pivot++){
            left=pivot; 
            right=pivot;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        //for even length
        for(int leftPivot=0;leftPivot<n-1;leftPivot++){
            left=leftPivot;
            right=leftPivot+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        return count;
    }
}
