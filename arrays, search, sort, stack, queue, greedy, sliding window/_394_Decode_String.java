class _394_Decode_String {
    //done on own using 2 stacks, one for string, one for nums
    public boolean isNum(char c){
        return (c>='0' && c<='9');
    }
    public String decodeString(String s) {
        Stack<Integer> intS=new Stack<>();
        Stack<String> stringS=new Stack<>();
        int n=s.length(),i=0;
        int num=0;
        while(i<n){
            if( isNum(s.charAt(i)) ){//number pushed
                String temp_num=""+s.charAt(i);
                i++;
                if(i<n && isNum(s.charAt(i)) ){
                    temp_num+=(""+s.charAt(i));
                    i++;
                    if(i<n && isNum(s.charAt(i)) ){
                        temp_num+=(""+s.charAt(i));
                        i++;
                    }
                }
                num=Integer.parseInt(temp_num);
                intS.push(num);
            }
            else if(s.charAt(i)==']'){
                //pop till pop.charAt(0)=='['
                String stemp="";
                while(stringS.peek().charAt(0)!='['){
                    stemp=stringS.pop()+stemp;
                }
                stringS.pop();//pop "["
                num=intS.pop();
                String s1="";
                for(int j=0;j<num;j++)//repeatition
                    s1+=stemp;
                stringS.push(s1);
                i++;
            }
            else{//neither num nor ']'
                //push
                stringS.push(""+s.charAt(i));
                i++;
            }
        }
        //
        String ans="";
        while(stringS.size()>0){
            ans= stringS.pop() + ans;
        }
        return ans;
    }
}
