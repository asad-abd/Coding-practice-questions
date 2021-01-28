package other sources;

public class c {
    
}

class countNumbersWhichCanBeConstructedUsingTwoNumbers{ 
    // Returns count of numbers from 1 to n that can be formed 
    // using x and y. 
    static int countNums(int n, int x, int y) 
    { 
        // Create an auxiliary array and initialize it 
        // as false. An entry arr[i] = true is going to 
        // mean that i can be formed using x and y 
        boolean[] arr=new boolean[n+1]; 
    
        // x and y can be formed using x and y. 
        if (x <= n) 
            arr[x] = true; 
        if (y <= n) 
            arr[y] = true; 
    
        // Initialize result 
        int result = 0; 
    
        // Traverse all numbers and increment 
        // result if a number can be formed using 
        // x and y. 
        for (int i=Math.min(x, y); i<=n; i++) 
        { 
            // If i can be formed using x and y 
            if (arr[i]) 
            { 
                // Then i+x and i+y can also be formed 
                // using x and y.			 
                if (i+x <= n) 
                    arr[i+x] = true; 
                if (i+y <= n) 
                    arr[i+y] = true; 
    
                // Increment result 
                result++; 
            } 
        } 
        return result; 
    } 
    
    // Driver code 
    public static void main(String[] args) 
    { 
        int n = 15, x = 5, y = 7; 
        System.out.println(countNums(n, x, y)); 
    } 
    }