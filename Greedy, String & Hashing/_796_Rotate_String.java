class _796_Rotate_String {
    public boolean rotateString(String s, String goal) {
        //brute force
        if(s.length()!=goal.length()) return false;
        if(s.length()==0 && goal.length()==0) return true;
        if(s.equals(goal)) return false;
        
        //AMAZING: s+s must have goal!!
        return (s+s).contains(goal);
        
        /*int n=goal.length();
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                int count=0;
                for(int k=0;k<n;k++){
                    if(s.charAt((k+i)%n)==goal.charAt((k+j)%n))
                        count++;
                }
                if(count==n) return true;
            }
        }*/
        //return false;
    }
}
