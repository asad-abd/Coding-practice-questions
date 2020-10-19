// hard: took a lotttt of time to understand. (seems so obvious now -_- )
class _902_NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int count=0;
        String num=""+n;
        
        
        for(int i=1;i<=num.length()-1;i++)
            count+=Math.pow(digits.length,i);
        
        if(num.length()==1){
            for(int j=0;j<digits.length;j++){
                if(Integer.parseInt(digits[j])<=num.charAt(0)-'0')
                    count++;
            }
            return count;
        }
        
        for(int i=0;i<num.length();i++){
            boolean moveToNextDigit=false;
            for(int j=0;j<digits.length;j++){
                
                if(Integer.parseInt(digits[j])<num.charAt(i)-'0'){
                    count+=Math.pow(digits.length,num.length()-i-1);
                }
                else if(Integer.parseInt(digits[j])==num.charAt(i)-'0'){
                    // move on to the next step ( next digit index )
                    moveToNextDigit=true;
                    
                    //Note: this will work for indices except the last!
                }
                
            }
            if(moveToNextDigit==false)// there was no digit <= num[i]
            {
                return count;
            }
        }
        return count+1;
        // vvvvimp: +1 because if we have reached till this point then we must have reached the last digit (units place) and got the 'else if' condition true but we never incremented count for it before this point! 
            
    }
}
