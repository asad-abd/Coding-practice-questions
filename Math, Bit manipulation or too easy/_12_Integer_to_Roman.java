//Done
import java.util.*;
class _12_Integer_to_Roman {
    //discussion one: amazinggg
    public String intToRoman(int num) {
        String I[]={"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String X[]={"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String C[]={"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String M[]={"", "M", "MM", "MMM","MMMM"};
        
        StringBuilder str=new  StringBuilder();
        if(num>=1000){
            str.append(M[num/1000]);
            num=num%1000;//1000s part is over
        }
        if(num>=100){
            str.append(C[num/100]);
            num=num%100;//100s part is over
        }
        if(num>=10){
            str.append(X[num/10]);
            num=num%10;//10s part is over
        }
        if(num>=1){
            str.append(I[num]);
        }
        return str.toString();
    }
    
    // first soln:
    public String intToRoman(int num) {
        HashMap<Integer,String> hmap = new HashMap<>();
        hmap.put(1, "I");
        ////hmap.put(2, "II");
        ////hmap.put(3 "III");
        hmap.put(4, "IV");
        hmap.put(5, "V");
        //hmap.put(6, "VI");
        //hmap.put(7, "VII");
        //hmap.put(8, "VIII");
        hmap.put(9, "IX");
        
        hmap.put(10, "X");
        hmap.put(40, "XL");
        hmap.put(50, "L");
        hmap.put(90, "XC");
        hmap.put(100, "C");
        hmap.put(400, "CD");
        hmap.put(500, "D");
        hmap.put(900, "CM");
        hmap.put(1000, "M");
        StringBuilder str=new StringBuilder();
        int pow=0;
        while(num>0){
            int number=(int)Math.pow(10,pow)*(num%10);
            StringBuilder temp=new StringBuilder();
            while(number>0){
                if(number>=1000){
                    temp.append(hmap.get(1000));
                    number-=1000;
                }
                else if(number>=900){
                    temp.append(hmap.get(900));
                    number-=900;
                }
                else if(number>=500){
                    temp.append(hmap.get(500));
                    number-=500;
                }
                else if(number>=400){
                    temp.append(hmap.get(400));
                    number-=400;
                }
                else if(number>=100){
                    temp.append(hmap.get(100));
                    number-=100;
                }
                else if(number>=90){
                    temp.append(hmap.get(90));
                    number-=90;
                }
                else if(number>=50){
                    temp.append(hmap.get(50));
                    number-=50;
                }
                else if(number>=40){
                    temp.append(hmap.get(40));
                    number-=40;
                }
                else if(number>=10){
                    temp.append(hmap.get(10));
                    number-=10;
                }
                else if(number>=9){
                    temp.append(hmap.get(9));
                    number-=9;
                }
                else if(number>=5){
                    temp.append(hmap.get(5));
                    number-=5;
                }
                else if(number>=4){
                    temp.append(hmap.get(4));
                    number-=4;
                }
                else{
                    temp.append(hmap.get(1));
                    number-=1;
                }
            }
            temp.append(str);
            str=temp;
            pow++;
            num/=10;
        }
        return str.toString();
    }
}
