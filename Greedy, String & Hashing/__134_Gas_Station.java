public class __134_Gas_Station {
    //Simulate a cycle by an array, such as: 0,1,2...n-1,0,1,2....n-2
    //total 2n-1 elements.
        //combine gas and cost into one array arr[i] = gas[i] - cost[i]
        //We want the cumulative sum to reach (i - 1 + n)%n (cycle) and any other station to be >= 0 as well 
        //M1) In arr. we can try all possible positive starting points and check if the cycle is possible -> O(n^2) solution
        
        //---- VV IMP maths logic ---- 
        //// If st is +ve but st++ is -ve and WE MOVE st TO st+1 THEN THE RESULTANT TILL j WILL STILL BE NEGATIVE, SINCE AFTER REMOVING st WE ARE REMOVING A +ve NUMBER FROM THE RESULTANT SUM. 
        //// AND THE NEW RESULTANT SUM WILL BE EVEN LESSER THAN BEFORE 
        //M2) Start from the starting point of the max sum subarray!
        //  eg arr [-2, 5, -3, -3, 4, 4]. max sum subarray is {4, 4}. start from there.
        // Verify if the answer is possible or not by checking the total sum

            //Maths proof of why solution EXISTS ---------------------
            //GIVEN: if total_sum < 0 then no solution possible (and viceversa) <<-----------
            //now, to prove that if total sum > 0 then answer exists. <<--------------
            
            //In the logical stmt p <=> q --> !q <=> !p --> CONTRAPOSITIVE!!
            //if solution possible then total_sum >= 0 
            //and if total_sum >= 0 then solution possible -> contrapositive is true!
            //we can also say that if the total_sum > 0 then there is a solution
        //If solution exists perform kadane on the cycle array (2n length array) 
        //and return the starting pos of the max Sum Subarray
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int arr[] = new int[gas.length];
        int st = -1, j = 0, n = arr.length;
        int totalSum = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i] = gas[i] - cost[i];
            totalSum += arr[i];
        }
        
        if(totalSum < 0)
            return -1;
        //else solution certainly exists
        //simply find the starting index of the max sum subarray
        
        //kadane on cycle (2*n length arr => array+array)
        int sum = 0, maxSum = Integer.MIN_VALUE;//don't -1 from -IINF!! -> becomes +IINF!
        int conti = 0;
        for(j = 0; j < 2 * n; j ++){
            
            sum += arr[j % n];
            conti ++;
            if(sum > maxSum){
                //System.out.println(sum+ " - i: "+i);
                maxSum = sum;
                st = (j  - conti + 1)%n ;
            }
            if(sum < 0){
                sum = 0;
                conti = 0;
            }
        }
        return st;
    }
}
