public class _146_LRU_Cache {
    //mistakes: 
    //1. Mapped val with node. Correct: key to node
    //2. Missed removing val key from hmap - get() gave old value instead of -1
    //3. forgot to connect head with tail initially
    class Node{
        Node prev, next;
        int key, val;
        Node(int Key, int Val){
            val = Val;
            key = Key;
        }
    }
    final int capacity;
    Node head;//assign unchangeable/dummy head
    Node tail;//assign unchangeable/dummy tail
    HashMap<Integer, Node> keyToNode;//helps to modify the deque in O(1) after doing get()/put().
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.keyToNode = new HashMap<>();
    }
    
    public int get(int key) {
        if(keyToNode.containsKey(key)) {
            //remove the key from its current pos and add at the front. (latest)
            Node node = keyToNode.get(key);//get the required node
            remove(node);
            addToFront(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(keyToNode.containsKey(key)){
            Node node = keyToNode.get(key);
            remove(node);
            addToFront(node);
            //remove the previous mapped key
            keyToNode.remove(node.key);
            //add the new value to map
            keyToNode.put(key, node);
            node.val = value; // forgot this 
        }
        else{
            if(keyToNode.size() >= capacity){
                //remove from tail end
                Node delete = tail.prev;
                remove(delete);
                //remove the previous mapped key
                keyToNode.remove(delete.key); // IMP
            }
            Node newNode = new Node(key, value);
            addToFront(newNode);
            keyToNode.put(key, newNode);
        }
        
    }
    
    //helper function 1
    public void remove(Node node){
        //change connections of node.prev & node.next
        node.prev.next = node.next;// added extra next and got NULL PTR EXECP
        node.next.prev = node.prev;        
    }
    //helper function 2
    public void addToFront(Node node){
        Node headNext = head.next;
        //nexts
        head.next = node;
        node.next = headNext;
        //prevs
        node.prev = head;
        headNext.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
/*How do we maintain the least recently used items? One way is to maintain something like a hashmap of ages and based on what is oldest, we remove it. But what would be the time complexity of this solution? We will have to traverse the entire map to find the oldest age and thus, it would take O(n) time. See HERE for this solution.

Can we do better? Turns out we can if we maintain a doubly linked list (DLL). The oldest item would always remain at the back of the list while the youngest at the front. In this way, we can delete an item in O(1) time. Whenever we access an element from the list, we push it to the front since it then becomes the most recently used item.
*/