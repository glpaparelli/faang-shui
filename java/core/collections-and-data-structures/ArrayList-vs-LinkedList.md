**Lists are data structures used for sequential element storage.** 
This means that every element of the list has both a predecessor and a successor, except for the first and last element. 

Lists are therefore ordered (unlike `Set`) collections which also allow duplicates. 

In Java `List<E>` is an interface under the `java.util` package. 

`ArrayList` and `LinkedList` are two different implementations of `List`. 
Mind that `LinkedList` also implements the `Queue` interface.
## Under the Hood
### ArrayList
An `ArrayList` is a **resizable array** that grows as additional elements are
added. 
This means that ArrayList internally contains an array of values and a counter
variable to know the current size at any point. If an element is added the size is 
increased, if an element is removed the size is decreased. 
**ArrayList contains a single array for data storage.** 
### LinkedList
A `LinkedList` is internally a **double-ended queue** of mutually-connected
elements. 
The first element points to the second, which points to the third and so on.
Since this is a doubly-linked list each element also points to its predecessor. 
`LinkedList` needs a custom data structure for data storage. The custom data structure
is a Node:  a linked list do not exist in a single place in memory, it contains different nodes connected to one another.
In order to store an element `B` is not enough to just store its value as you would
with an `ArrayList` but you also have to set up the pointers.
With `LinkedList` we can always assume the existence of two pointers: head and tail,
that respectively points to the first and last element of the list. 
### ArrayList vs LinkedList
**Fetching Elements** with `get(int index)`
- `ArrayList`: 
	- Under the hood the ArrayList is a (resizable) array, hence this operation is performed in constant time: $O(1)$.
- `LinkedList`: 
	- The list needs to be traversed and follow each of the node's connections until the wanted element is found, so this operations costs linear time on the number of elements in the list: $O(n)$

**Inserting Elements** with `add(E element)` 
- `ArrayList`: 
	- Inserting at the end: 
		- extend the length by one and insert the element at the end. 
	- Inserting at a given position: 
		- break the array at the place you want to insert, copy everything after that point and move it to the right and add the new element at that index. 
		- The operation is done in linear time $O(n)$ worst case: say we want to insert at index 0, the larger the copied part the slower this operation is
- `LinkedList`: 
	- Obvious approach, at most two pointers need to be updated. 
        - `prev.next = newElement`
        - `newElement.next = succ`
	- While the cost is still linear because reaching the position where the element should be inserted is inefficient ($O(n)$) adding at an index is way more efficient with `LinkedList`


**Finding Elements** with `indexOf(E element)`
Both `LinkedList` and `ArrayList` do the same thing: full traversal: $O(n)$
  
**Deleting Elements** with `remove(E element)`
- `ArrayList`: 
	- Removing an item at a given index requires to copy a portion of the `ArrayList`,  reinitialize the array without the removed value and shifting the copied part to the left: $O(n)$
- `LinkedList`: 
	- To remove just "skip" the element by updating the pointer of the previous element. 
	- There is still the need to reach the element that is before the target, so the complexity is still $O(n)$, but as before it is better than `ArrayList`
#### Conclusions
**Use ArrayList** if inserting/removing is done rarely and fetching elements is very common. 
**Use LinkedList** if inserting/removing is very common and fetching elements is done rarely.
