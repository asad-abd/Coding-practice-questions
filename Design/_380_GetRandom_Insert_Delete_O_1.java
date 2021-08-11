public class _380_GetRandom_Insert_Delete_O_1 {
    //Amazing trick - swap the end with random index and remove with last!!

    //From discuss: ArrayList is used to store numbers and serve the getRandom() method. 
    //The Map contains the mapping between the value and its index in the ArrayList. 
    //The Map helps to check whether a value is already inserted or not. The main trick is when you REMOVE a value. 
    //ArrayList's remove method is O(n) if you remove from random location. 
    ////To overcome that, we SWAP the values between (randomIndex, lastIndex) and ALWAYS REMOVE the entry from the end of the list. 
    //After the swap, you need to update the new index of the swapped value (which was previously at the end of the list) in the map.
}
