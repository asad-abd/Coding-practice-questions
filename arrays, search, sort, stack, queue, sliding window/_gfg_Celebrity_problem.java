public class _gfg_Celebrity_problem {
    //first O(n^2) solution that apparently got accepted lol
    int celebrity(int M[][], int N)
    {
    	//check for a row of all 0s - if none -> return -1, else pass index below
    	//check if the above index-column is set to 1 in all other rows(except the index)
    	int rind=-1;
    	for(int r=0;r<N;r++){
    	    int count=0;
    	    for(int c=0;c<N;c++){
    	        if(M[r][c]==0)
    	            count++;
    	    }
    	    if(count==N){
    	        rind=r;
    	        break;
    	    }
    	}
    	if(rind==-1) return -1;
    	
    	for(int r=0;r<N;r++){
    	    if(r!=rind && M[r][rind]==0) return -1;
    	}
    	return rind;
    }
    //O(n) solution based on recursion (derived from stack solution)
	//stack approach. push all on the stack. pop 2 and push one. simply recheck at the end
	boolean knows(int a, int b, int M[][]){
        return M[a][b]==1?true: false;
    }
    int celeb=-1;
    void f(int top, int candidate, int M[][]){
        //candidate>top always
        if(top==-1){
            //System.out.println(top);
            celeb=candidate;
        }
        else if(knows(top,candidate,M)){
            //candidate is still ok but top can't be
            f(top-1,candidate,M);
        }
        else{
            f(top-1,top,M);
        }
    }
    //Function to find if there is a celebrity in the party or not.
    int celebrityRecur(int M[][], int N)
    {
    	f(N-2,N-1,M);
    	//check if celeb is valid
    	for(int r=0;r<N;r++){
    	    if(r!=celeb && M[r][celeb]!=1) return -1;
    	}
    	return celeb;
    }
	
	//another approach: 2 pointer : a:0--> cross each other <--n-1:b 
	//confirm a/b as the answer.
}
