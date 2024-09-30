`TreeMap` in Java is a part of the [[Java Collections|Java Collections Framework]] and implements the `NavigableMap` and `SortedMap` interfaces.
It is used to store key-value pairs in a sorted order, based on the natural ordering of the keys or by a specified comparative. 
`TreeMap` is implemented using a Red-Black tree, which is a type of self-balancing binary search tree.
### Key Features of `TreeMap`
1. **Sorted Order**: `TreeMap` maintains the keys in their natural order (if the keys implement `Comparable`) or in the order defined by a provided comparator.
2. **Unique Keys**: Like [[HashMap]], `TreeMap` does not allow duplicate keys. If a key is reinserted, it updates the existing key-value pair.
3. **NavigableMap Interface**: `TreeMap` provides methods for navigating through the map, allowing you to find entries less than, greater than, or equal to a given key.
4. **Logarithmic Time Complexity**: The time complexity for basic operations like insertion, deletion, and access is O(log n) due to the underlying Red-Black tree structure.
5. **Not Synchronized**: Like [[HashMap]] and `HashSet`, `TreeMap` is not synchronized, making it not thread-safe unless external synchronization is applied.
6. **Null Keys**: `TreeMap` does not allow null keys. If you attempt to insert a null key, it will throw a `NullPointerException`. However, it allows multiple null values.
### Performance Considerations
- **Access Time**: The average time complexity for basic operations like insertion, deletion, and access is $O(\log n)$.
- **Memory Overhead**: Due to the underlying tree structure, `TreeMap` may have higher memory overhead compared to [[HashMap]].