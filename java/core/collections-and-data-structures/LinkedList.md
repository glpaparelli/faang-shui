`LinkedList` in Java is a part of the [[Java Collections|Java Collection Framework]] and implements the `List` and `Deque` interfaces. 
Unlike [[ArrayList]], which is backed by an array, `LinkedList` is built **using a doubly linked list data structure.** This allows for more efficient insertion and removal of elements at both ends and in the middle of the list.
### Key Features of `LinkedList`
1. **Dynamic Size**: Like `ArrayList`, `LinkedList` can grow and shrink in size dynamically as elements are added or removed.
2. **Node Structure**: Each element in a `LinkedList` is represented by a node that contains references to both the next and previous nodes, allowing for bidirectional traversal.
3. **Order Preservation**: `LinkedList` maintains the order of insertion, just like `ArrayList`.
4. **Null Elements**: It allows for the insertion of null values.
5. **Efficient Insertions/Deletions**: `LinkedList` offers better performance for insertion and deletion operations, particularly when manipulating elements at the beginning or middle of the list, as these operations are O(1) if you already have a reference to the node.
6. **Not Synchronized**: Similar to `ArrayList`, `LinkedList` is not synchronized, making it not thread-safe without external synchronization.
### Performance Considerations
- **Access Time**: The time complexity for accessing elements is $O(n)$, as it may require traversing the list to find the specified index.
- **Insertion/Deletion**: Inserting or deleting elements at the beginning or end is $O(1)$, and in the middle is $O(n)$ because you may need to traverse the list to find the position.