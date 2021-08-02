class _gfg_WRAP_WORD_hard {

    //the below (RECURSIVE) ran correctly for testcases but TLE on run. means correct algo but slow.
    //if(n==0) return k-occupied;//this condition caused me 2 hrs!!!!!!!!!!!!!!!!!!

    //returns the minimum extra spaces for line 'line'.n is the current size of array. ocupied is the space currently occupied by the characters on the line
    int knap(int a[], int n, int line, int k, int occupied){
        if(n==0) return k-occupied;//this condition caused me 2 hrs!!!!
        //think abt it. If i have placed all the words, the lastly filled line might have some empty space!

        if(occupied==0){
            //must add the word
            return knap(a,n-1,line,k,a[n-1]);
        }
        else if(occupied+1+a[n-1]<=k){
            //return the min of the 2
            if(line!=0)
                return Math.min(knap(a,n-1,line,k,occupied+1+a[n-1]), knap(a,n,line+1,k, 0) + (k-occupied));
            else
                return Math.min(knap(a,n-1,line,k,occupied+1+a[n-1]), knap(a,n,line+1,k, 0));
        }
        else{//cannot consider it, change line
            if(line!=0)
                return knap(a,n,line+1,k, 0) + (k-occupied);
            else
                return knap(a,n,line+1,k, 0);
        }
    }
    public int solveWordWrap (int[] nums, int k)
    {
        return knap(nums,nums.length,0,k,0);
    }

    //// optimization 1 - HASHMAP  - Again TLE. but not WA
    HashMap<String,Integer> hmap;
    int knap1(int a[], int n, int line, int k, int occupied){
        if(n==0) return k-occupied;//this condition caused me 2 hrs!!!!
        //think abt it. If i have placed all the words, the lastly filled line might have some empty space!
        String s=""+n+","+line+","+occupied;
        if(hmap.containsKey(s)) return hmap.get(s);
        
        if(occupied==0){
            //must add the word
            hmap.put(s, knap(a,n-1,line,k,a[n-1]) );
            return hmap.get(s);
        }
        else if(occupied+1+a[n-1]<=k){
            //return the min of the 2
            if(line!=0)
                hmap.put(s,Math.min(knap(a,n-1,line,k,occupied+1+a[n-1]), knap(a,n,line+1,k, 0) + (k-occupied)) );
            else
                hmap.put(s,Math.min(knap(a,n-1,line,k,occupied+1+a[n-1]), knap(a,n,line+1,k, 0)) );
        }
        else{//cannot consider it, change line
            if(line!=0)
                hmap.put(s,knap(a,n,line+1,k, 0) + (k-occupied));
            else
                hmap.put(s,knap(a,n,line+1,k, 0));
        }
        return hmap.get(s);
    }
    // optimization 2 array: may work in interview
    int t[][][];
    int knap2(int a[], int n, int line, int k, int occupied){
        if(n==0) return k-occupied;//this condition caused me 2 hrs!!!!
        //think abt it. If i have placed all the words, the lastly filled line might have some empty space!
        if(t[n][line][occupied]!=-1) return t[n][line][occupied];
        
        if(occupied==0){
            //must add the word
            return t[n][line][occupied]=knap(a,n-1,line,k,a[n-1]);
        }
        else if(occupied+1+a[n-1]<=k){
            //return the min of the 2
            if(line!=0)
                return t[n][line][occupied]=Math.min(knap(a,n-1,line,k,occupied+1+a[n-1]), knap(a,n,line+1,k, 0) + (k-occupied));
            else
                return t[n][line][occupied]=Math.min(knap(a,n-1,line,k,occupied+1+a[n-1]), knap(a,n,line+1,k, 0));
        }
        else{//cannot consider it, change line
            if(line!=0)
                return t[n][line][occupied]=knap(a,n,line+1,k, 0) + (k-occupied);
            else
                return t[n][line][occupied]=knap(a,n,line+1,k, 0);
        }
    }
    public int solveWordWrap2 (int[] nums, int k)
    {
        t=new int[nums.length+1][nums.length+1][k+1];
        for(int i=0;i<=nums.length;i++)
            for(int j=0;j<=nums.length;j++)
                for(int p=0;p<=k;p++)
                    t[i][j][p]=-1;
        return knap2(nums,nums.length,0,k,0);
    }
}
