
public class LinearProbingHashST<Key, Value> {

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of linear probing table
    private Node[] hashTableArr;

    
    private static class Node
    {
    	private Object key; 
    	private Object val; 
    	private int status;
    	
    	public Node(Object key,Object val) {
    		this.key=key;
    		this.val=val;
    		status=0;
    	}
    	
    	public String toString() {
    		return "["+key+ ", '"+val+ "', "+status+"]";
    	}
    }
    
    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        hashTableArr = new Node[m];
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     */
    public boolean contains(Key key) {
    	return isFound(key) != null;
    }

    // hash function for keys - returns value between 0 and m-1
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }


    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void rehash(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        
        for (int i = 0; i < m; i++) {
            if (hashTableArr[i] != null) {
                temp.insert((Key)hashTableArr[i].key, (Value)hashTableArr[i].val);
            }
        }
        hashTableArr=temp.hashTableArr;
        m = temp.m;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     */
    public void insert(Key key, Value val) {
       
        if (val == null) {
            delete(key);
            return;
        }

        n++;
        // double table size if 50% full
        if (n >= m/2) rehash(2*m);

        int i;
        for (i = hash(key); hashTableArr[i] != null; i = (i + 1) % m) {
            if (hashTableArr[i].key.equals(key)) {
            	hashTableArr[i].val = val;
                return;
            }
        }
        hashTableArr[i]=new Node(key,val);
       
    }

    public void find(Key key) {
    	if(isFound(key)!=null)
    		System.out.println(isFound(key));
    	else
    		 System.out.println("item not found");
    }
    
    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with {@code key};
     *         {@code null} if no such value
     */
    
    
    private Value isFound(Key key) {
       
        for (int i = hash(key); hashTableArr[i] != null; i = (i + 1) % m)
            if (hashTableArr[i].key.equals(key) && hashTableArr[i].status==0)
                return (Value)hashTableArr[i].val;
        return null;
    }

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     */
    public void delete(Key key) {
       
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (!key.equals(hashTableArr[i].key)) {
            i = (i + 1) % m;
        }

        // change status to 1 to indicate that it's deleted
        hashTableArr[i].status=1;

        n--;
}
    
    public void printTable()
    {
   
    	System.out.println("\nLinear Probing Hash Table:");
        for (int i = 0; i < m; i++)
            if (hashTableArr[i] != null)
                System.out.println(hashTableArr[i]);
            else
            	System.out.println("[0, '',0]");
            	
    }

    /**
     * Returns all keys in this symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in this symbol table
     */
  
    /*public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }*/



}