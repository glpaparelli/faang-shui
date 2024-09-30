The **Java Collection Framework** is a unified architecture that provides a set of classes and interfaces for managing groups of objects. It is part of the `java.util` package and is one of the most powerful aspects of Java programming, providing a comprehensive and consistent way to handle collections (groups of objects), like lists, sets, queues, and maps.
### Key Features of the Java Collection Framework:
1. **Unified Architecture**: All collections, regardless of the specifics, use the same method signatures, making it easier to manipulate them consistently.
2. **Ease of Use**: It provides various utility methods to simplify common operations like sorting, searching, and shuffling collections.
3. **Generic Support**: Java collections are type-safe, which means you can specify the type of objects the collection will hold, reducing the risk of runtime errors.
4. **High-Performance Implementations**: It provides highly optimized data structures (like ArrayList, HashMap, etc.) for efficient use.
5. **Flexibility**: It allows dynamic resizing of collections and supports thread-safe and non-thread-safe operations (via classes like `Collections.synchronizedList`).
### Hierarchy of Java Collection Framework
#### 1. Interfaces
**These define the core behaviors of different types of collections.** 

**Collection Interface**: The root interface for all collections. It defines basic operations like adding, removing, and querying elements.

**List Interface**: Represents an ordered collection (also known as a sequence). 
Lists allow duplicates.
Main Implementations: `ArrayList`, `LinkedList`, `Vector`

**Set Interface**: Represents a collection that does not allow duplicate elements.
Main Implementations: `HashSet`, `LinkedHashSet`, `TreeSet`

**Queue Interface**: Represents a collection designed for holding elements prior to processing. Queues typically order elements in FIFO (First-In-First-Out).
Main Implementations: `PriorityQueue`, `LinkedList`

**Map Interface**: Represents a collection of key-value pairs, where each key is unique.
Main Implementations: `HashMap`, `TreeMap`, `LinkedHashMap`, `Hashtable`
##### Interfaces in Detail 
- **Collection Interface**: The root interface that is extended by other collection types. It includes methods like:
    - `add()`: Adds an element.
    - `remove()`: Removes an element.
    - `size()`: Returns the number of elements.
    - `contains()`: Checks if an element is in the collection.
- **List Interface**: Extends `Collection` and allows ordered collections with duplicates. Common methods:
    - `get(int index)`: Returns the element at a specified position.
    - `add(int index, E element)`: Inserts the element at a specified position.
    - `remove(int index)`: Removes the element at the specified position.
- **Set Interface**: Extends `Collection` but does not allow duplicates. Common methods:
    - `add(E e)`: Adds an element, returning `false` if it’s already present.
    - `remove(Object o)`: Removes an element.
- **Map Interface**: Does **not** extend `Collection` but represents key-value pairs. Common methods:
    - `put(K key, V value)`: Associates a value with a key.
    - `get(Object key)`: Retrieves the value associated with the key.
    - `remove(Object key)`: Removes the key-value pair.
#### 2. Classes
**These are the concrete implementations of the interfaces, providing different behaviors and performance characteristics.** 

**Common classes include:**
- [[ArrayList]]: A dynamic array that grows as elements are added. Provides fast access by index but slower operations for insertion and deletion.
- [[LinkedList]]: Implements a doubly-linked list. It is efficient for inserting and removing elements, but slower for random access compared to `ArrayList`.
- [[HashSet]]: Implements the `Set` interface backed by a hash table, making it fast for lookups but unsorted.
- [[TreeSet]]: Implements a `SortedSet` where elements are stored in ascending order, backed by a balanced binary tree (Red-Black Tree).
- [[HashMap]]: Implements a `Map` based on hashing, offering fast lookups but no ordering.
- [[TreeMap]]: Implements a `Map` where elements are sorted by key.
#### 3. Utility Classes
**Collections**: A utility class that contains static methods for operations like sorting, searching, and synchronizing collections.

**Example: sorting**
```java
ArrayList<Integer> numbers = new ArrayList<>(1,4,-1,5,5,6);
Collections.sort(numbers);
```
**Example: sorting in reverse order**
```java
ArrayList<Integer> numbers = new ArrayList<>(1,4,-1,5,5,6);
Collections.sort(numbers, Collections.reverseOrder());
```

**Arrays**: Provides utility methods for **arrays** (considered a type of collection).

**Example: array to string**
```java
int[] numbers = {42, 13, 56, 8, 29};
System.out.println("numbers: " + Arrays.toString(numbers));
```

**Example: array as list**
```java
List<Integer> numbersList = new ArrayList<>(Arrays.asList(3,2,1,5));
```
### When and Which
![[Screenshot from 2024-09-30 17-34-34.png | center | 700]]
