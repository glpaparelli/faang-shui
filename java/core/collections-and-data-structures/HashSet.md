`HashSet` in Java is part of the [[Java Collections|Java Collection Framework]] and implements the `Set` interface. 
It is used to store a collection of unique elements, ensuring that no duplicate entries are allowed. Internally, it is backed by a hash table, which provides efficient access, insertion, and deletion operations.
### Key Features of `HashSet`
1. **Uniqueness**: `HashSet` does not allow duplicate elements. If you try to add a duplicate, the new entry will simply be ignored.
2. **Unordered Collection**: The elements in a `HashSet` are not stored in any specific order. The order may change over time, especially after operations like adding or removing elements.
3. **Fast Operations**: The time complexity for basic operations like add, remove, and contains is average $O(1)$, thanks to the underlying hash table structure.
4. **Null Elements**: `HashSet` allows the insertion of a single null element.
5. **Not Synchronized**: Like [[ArrayList]] and [[LinkedList]], `HashSet` is not synchronized, making it not thread-safe unless external synchronization is applied.
6. **Capacity and Load Factor**: `HashSet` has an initial capacity and a load factor that controls when to increase the capacity of the underlying array. When the number of elements exceeds the product of the load factor and the current capacity, the `HashSet` is resized.
### Performance Considerations
- **Access Time**: The average time complexity for accessing elements is $O(1)$, but this can degrade to $O(n)$ in cases of many hash collisions.
- **Insertion/Deletion**: Average time complexity for insertion and deletion operations is $O(1)$.