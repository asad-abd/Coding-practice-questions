class _415_Add_strings {
    //did this after 3 week break.
    //Takes: utterly messed up the carry calc (wrote it x + y + carry - z) 
    //Got MLE due to wrong carry calc, took 30 mins to get AC. - breaks destroy you!
    
    public String addStrings(String num1, String num2) {
        //ans[i] = (x + y + carry) % 10
        //carry = x + y + carry - ans[i]
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int x, y, z, carry = 0;
        StringBuilder ans = new StringBuilder();
        while(i >= 0 || j >= 0){
            x = 0;
            y = 0;
            if(i >= 0)
                x = num1.charAt(i) - '0';
            if(j >= 0)
                y = num2.charAt(j) - '0';
            z = (x + y + carry) % 10;
            //System.out.println(x + " y: "+ y + " z: "+z +" c: "+ carry );
            carry = (x + y + carry) / 10;
            ans.append(z);
            
            i--;
            j--;
        }
        while(carry > 0) {
            ans.append(carry % 10);
            carry /= 10;
            
            
        }
        return ans.reverse().toString();
    }
}