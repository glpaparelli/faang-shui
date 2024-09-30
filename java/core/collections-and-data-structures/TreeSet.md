`TreeSet` in Java is a part of the [[Java Collections|Java Collections Framework]] and implements the `NavigableSet` and `SortedSet` interfaces. 
It is used to store unique elements in a sorted order, based on the natural ordering of the elements or by a specified comparator. 
Internally, `TreeSet` is implemented using a [[TreeMap]], which means it utilizes a Red-Black tree data structure.
### Key Features of `TreeSet`
1. **Sorted Order**: `TreeSet` maintains its elements in sorted order. The order can be determined by the natural ordering of the elements or by a comparator provided at the time of creation.
2. **Unique Elements**: `TreeSet` does not allow duplicate elements. If you try to add a duplicate, it will be ignored.
3. **NavigableSet Interface**: `TreeSet` provides methods for navigating through the set, allowing you to find elements less than, greater than, or equal to a given element.
4. **Logarithmic Time Complexity**: The time complexity for basic operations like insertion, deletion, and access is $O(\log n)$ due to the underlying Red-Black tree structure.
5. **Not Synchronized**: Like other collection classes such as [[HashSet]] and [[ArrayList]], `TreeSet` is not synchronized, making it not thread-safe unless external synchronization is applied.
6. **Null Elements**: `TreeSet` does not allow null elements. Attempting to insert a null value will throw a `NullPointerException`.
### Performance Considerations
- **Access Time**: The average time complexity for basic operations like insertion, deletion, and access is $O(\log n)$.
- **Memory Overhead**: Because of its underlying tree structure, `TreeSet` may consume more memory compared to `HashSet`.