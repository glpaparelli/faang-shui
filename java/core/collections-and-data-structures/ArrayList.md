`ArrayList` in Java is a part of the [[Java Collections|Java Collection Framework]] and is used to store a dynamically resizable array of objects. 
It implements the `List` interface and is a popular choice for handling collections of elements due to its flexible size and rich set of methods for manipulating data.

ArrayList internally contains an array of values and a counter
variable to know the current size at any point. If an element is added the size is 
increased, if an element is removed the size is decreased. 
**ArrayList contains a single array for data storage.** 
### Key Features of `ArrayList`
1. **Dynamic Sizing**: Unlike arrays, which have a fixed size, an `ArrayList` can grow and shrink dynamically as elements are added or removed.
2. **Random Access**: It provides fast random access to elements, as it is backed by an array, allowing constant-time performance for retrieving elements by their index.
3. **Order Preservation**: `ArrayList` maintains the order of insertion. Elements are stored in the sequence they are added.
4. **Null Elements**: It allows null values, so you can add null elements without any issues.
5. **Iterators**: `ArrayList` provides iterators to traverse through the elements. You can use `for-each` loops, as well as `Iterator` and `ListIterator` interfaces.
6. **Not Synchronized**: By default, `ArrayList` is not synchronized, meaning it is not thread-safe. If multiple threads access an `ArrayList` concurrently and at least one of the threads modifies it, it must be synchronized externally.
### Performance Considerations
- **Access Time**: The time complexity for accessing elements is $O(1)$.
- **Insertion/Deletion**: Inserting or removing elements at the end of the list is $O(1)$, but inserting or deleting elements in the middle of the list can take $O(n)$ time, as elements need to be shifted.