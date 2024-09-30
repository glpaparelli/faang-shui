`HashMap` in Java is a part of the [[Java Collections|Java Collections Framework]] and implements the `Map` interface. 
It is used to store key-value pairs, allowing for efficient retrieval, insertion, and deletion of elements based on keys. The underlying data structure for a `HashMap` is a hash table, which provides average constant-time complexity for these operations.

An `HashMap` can be seen as an array of lists of entry (pairs `<K,V>`), and a bucket is a certain element of the array.
### Key Features of `HashMap`
1. **Key-Value Pair Storage**: `HashMap` stores data in the form of key-value pairs, where each key is unique, and each key maps to exactly one value.
2. **Null Keys and Values**: `HashMap` allows one null key and multiple null values.
3. **Unordered Collection**: The order of the elements is not guaranteed, and it may change when new elements are added or removed.
4. **Fast Access**: The average time complexity for `get`, `put`, and `remove` operations is O(1). However, this can degrade to O(n) in cases of hash collisions.
5. **Not Synchronized**: `HashMap` is not synchronized, making it not thread-safe. If you need to use it in a concurrent environment, consider using `ConcurrentHashMap` or synchronize it externally.
6. **Capacity and Load Factor**: `HashMap` has an initial capacity and a load factor. When the number of entries exceeds the product of the load factor and the current capacity, the `HashMap` is resized, which may involve rehashing the existing entries.
### Performance Considerations
- **Access Time**: Average time complexity for accessing, inserting, and removing entries is $O(1)$.
- **Memory Overhead**: Because of its underlying array and linked list structure (or tree structure in Java 8+ for buckets with high collisions), `HashMap` may consume more memory than a simple array or list.