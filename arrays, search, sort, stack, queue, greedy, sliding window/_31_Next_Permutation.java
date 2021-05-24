public class _31_Next_Permutation {
    //VVVVIMP - review later
    //understood algo but err in my imple
    //this is someone else's imple
    //visualize graphically - my only intuition
    //also- to reverse. simply write:-
    //while(start<end) swap(start++,end--);
    public void nextPermutation(int[] num) {
        int n=num.length;
        if(n<2)
            return;
        int index=n-1;        
        while(index>0){
            if(num[index-1]<num[index])
                break;
            index--;
        }
        if(index==0){
            reverseSort(num,0,n-1);
            return;
        }
        else{
            int val=num[index-1];
            int j=n-1;
            while(j>=index){
                if(num[j]>val)
                    break;
                j--;
            }
            swap(num,j,index-1);
            reverseSort(num,index,n-1);
            return;
        }
    }

    public void swap(int[] num, int i, int j){
        int temp=0;
        temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }

    public void reverseSort(int[] num, int start, int end){   
        if(start>end)
            return;
        for(int i=start;i<=(end+start)/2;i++)
            swap(num,i,start+end-i);
    }
}
