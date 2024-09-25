HashMap works on the principle of hashing. 

To understand hashing we first review the following three concepts 
1) **hash function:** 
	- Used to create the *hash* of something. The hash is a semi-unique code, in this case an integer, that is "intrinsic" of the hashed item.
2) **hash value:** 
	- The hash value is the value, an integer, returned by the hash function
3) **bucket:** 
	1) A bucket is used to store key-value pairs. 
	2) A bucket can have multiple key-value: `HashMap` use simple linked lists to store objects. 

An `HashMap` can be seen as an array of lists of entry (pairs `<K,V>`), and a bucket is a certain element of the array.
#### Method: V get(K key)
The method `V get(K key)` in `HashMap` calls the method `hashCode()` on `key` and applies the returned hash value to its own static hash function to find the bucket location where **both** the key and the values are stored, in the form of a nested class called `Entry` (`Map.Entry`).

Whenever we call `get(K key)` first it is checked whether `key` is `null` or not. 
There can only one `null` key in the map: if `key` is `null` then we get always the index $0$.

**Then the behavior is the following:** 
- invoke `get(K key)`
- check whether `key` is `null`: 
	- `key` is `null`: return the bucket entry at index `0`
	- `key` is not `null`
		- we get an hash using the method `int hashVal = key.hashCode()`
		- then an inner hash function is invoked: 
			- `hashVal = HashMap.hash(hashVal)`
			- this is done as defense to poor hash function in the `hashCode()` method, which is overridden by the user of the map, hence it could be a bad hash function
	- `hashVal` is used to find the the bucket location at which the entry object is stored. 

#### Method: V put(K key, V value)
**TODO**

#### What happens if two different keys have the same hash?
The `equals()` method is crucial here. 
The bucket is a simple linked list: simply traverse the list using the `.equals()` to find a match between the target key and the stored keys. 
Then the corresponding value is returned
#### What happens if we use an already used key?
The entry is updated and to that key will now correspond the new value. 
**In other words: using an existing key results in an overriding of the value.**
#### How we measure the performance of HashMap?
According to the Oracle Java docs an instance of `HashMap` has two parameters
that affects its performance: initial capacity and load factor. 
  - **Capacity:** 
	  - Number of buckets of the `HashMap` 
  - **Load Factor:** 
	  - Measure how full the hash table is allowed to get before its capacity is automatically increased. 
	  - When the number of entries in the table exceed the product of the load factor and current capacity the table is rehashed: the internal data structure is rebuilt.

**Observations:**
- The current capacity and the number of entries are not the same thing because there are collisions
- The default value for the load factor is $0.75$
#### What is the time complexity of get() and put()?
 Both methods perform in constant time ($O(1)$) assuming that the hash function disperses the elements properly along the buckets.  