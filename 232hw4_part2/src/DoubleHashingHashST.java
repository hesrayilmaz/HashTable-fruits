public class DoubleHashingHashST<Key, Value> {

    private int n;           // number of key-value pairs in the symbol table
    private int m;           // size of double hashing table
    private Node[] hashTableArr;
    private int totalprimeSize;


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
    public DoubleHashingHashST(int capacity) {
        m = capacity;
        n = 0;
        hashTableArr = new Node[m];
        totalprimeSize = getPrime();
    }

 // To check for the prime number
    public int getPrime()
    {
        // Iterating using for loop in reverse order
        for (int i = m- 1; i >= 1; i--) {
 
            // Initially assigning count to zero
            int cnt = 0;
 
            // Now, iterating from 2 upto the desired number
            // to be checked by dividing it with all no
            // in between [2 - no]
            for (int j = 2; j * j <= i; j++)
 
                // If number is divisible
                // means not a prime number
                if (i % j == 0)
 
                    // So simply move to next number
                    // to check for divisibility by
                    // incrementing the count variable
                    cnt++;
 
            // By now number is not divisible
            // hence count holds 0 till last
            if (cnt == 0)
 
                // It means it is a prime number so
                // return the number as it is a prime number
                return i;
        }
 
        // Returning a prime number
        return 3;
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
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        return find(key) != null;
    }

    // hash function for keys - returns value between 0 and m-1
    private int hash1(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }


    private int hash2(Key key)
    {
        int myhashVal2 = key.hashCode();
        myhashVal2 %= m;
        if (myhashVal2 < 0)
            myhashVal2 += m;
        return totalprimeSize - myhashVal2 % totalprimeSize;
    }
    
    
    // resizes the hash table to the given capacity by re-hashing all of the keys
    private void rehash(int capacity) {
    	DoubleHashingHashST<Key, Value> temp = new DoubleHashingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (hashTableArr[i] != null) {
                temp.insert((Key)hashTableArr[i].key, (Value)hashTableArr[i].val);
            }
        }
        hashTableArr=temp.hashTableArr;
        m    = temp.m;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void insert(Key key, Value val) {

        if (val == null) {
            delete(key);
            return;
        }

        n++;
        // double table size if 50% full
        if (n >= m/2) rehash(2*m);

        
        int hashing1;
        int hashing2 = hash2(key);
        for (hashing1 = hash1(key); hashTableArr[hashing1] != null; hashing1 += hashing2, hashing1 %= m) {
            if (hashTableArr[hashing1].key.equals(key)) {
            	hashTableArr[hashing1].val = val;
                return;
            }
        }
        hashTableArr[hashing1]=new Node(key, val);
       
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with {@code key};
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value find(Key key) {
    	 
         for (int hash1 = hash1(key), hash2 = hash2(key); hashTableArr[hash1] != null;  hash1 += hash2,hash1 %= m)
             if (hashTableArr[hash1].key.equals(key))
                 return (Value)hashTableArr[hash1].val;
        
         System.out.println("item not found");
         return null;
       
    }
   

    /**
     * Removes the specified key and its associated value from this symbol table     
     * (if the key is in this symbol table).    
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        
        if (!contains(key)) return;

        // find position i of key
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        while (!key.equals(hashTableArr[hash1].key)) {
        	hash1 += hash2;
            hash1 %= m;
        }

        // change status to 1 to indicate that it's deleted
        hashTableArr[hash1].status=1;

        n--;

    }
    
    public void printTable()
    {
    	System.out.println("\nDouble Hashing Hash Table:");
    	
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