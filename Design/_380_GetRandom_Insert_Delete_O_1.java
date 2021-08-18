public class _380_GetRandom_Insert_Delete_O_1 {
    //Amazing trick - swap the end with random index and remove with last!!

    //From discuss: ArrayList is used to store numbers and serve the getRandom() method. 
    //The Map contains the mapping between the value and its index in the ArrayList. 
    //The Map helps to check whether a value is already inserted or not. The main trick is when you REMOVE a value. 
    //ArrayList's remove method is O(n) if you remove from random location. 
    ////To overcome that, we SWAP the values between (randomIndex, lastIndex) and ALWAYS REMOVE the entry from the end of the list. 
    //After the swap, you need to update the new index of the swapped value (which was previously at the end of the list) in the map.
    /** Initialize your data structure here. */
    HashMap<Integer, Integer> hmap; // (number, index in the arrList)
    ArrayList<Integer> arr; // number 
    public RandomizedSet() {
        hmap = new HashMap<>();
        arr = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean alreadyPresent = hmap.containsKey(val);
        if(alreadyPresent)
            return false;
        hmap.put(val, arr.size());//this must be first (bfr addn to the list)
        arr.add(val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hmap.containsKey(val)) return false;
        int removeInd = hmap.get(val);
        //swap
        Collections.swap(arr, removeInd, arr.size() - 1);
        //update the hmap after swap!!! -- SMD
        hmap.put(arr.get(removeInd), removeInd);//mapping the value at last pos (after swap) to its new position.
        //remove from end
        arr.remove(arr.size() - 1);
        hmap.remove(val);
        //System.out.println
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
         int randInd = (int)(Math.random()*arr.size());
        return arr.get(randInd);
    }
    /*old swap code
            //int temp = arr.get(arr.size() - 1);
            //arr.set(arr.size() - 1, arr.get(removeInd));
            //arr.set(removeInd, temp);
    */
}
