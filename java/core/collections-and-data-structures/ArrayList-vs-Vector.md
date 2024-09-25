`ArrayList` and `Vector` both implement the `List` interface and **both use dynamically resizable arrays for their internal data structure.** 
#### ArrayList vs Vector
- **multi-threading:**
	- `ArrayList` is not synchronized: multiple threads can work on it at the same time
	- `Vector` is synchronized: only one thread at a time can work on it
- **resize rate:**
	- `ArrayList` increments itself of $50\%$ when the max capacity is reached
	- `Vector` increments itself of $100\%$ when the capacity is reached
- **legacy:**
	- `ArrayList` is not a legacy class
	- `Vector` is a legacy class
- **element traversing:**
	- `ArrayList` uses the `Iterator` interface to traverse its elements
	- `Vector` uses both the `Iterator` interface and the `Enumeration` interface to traverse its elements
- **performance:**
	- `ArrayList` performs better
#### Conclusions
`ArrayList` is newer and faster and it usually the default and preferable choice. 
The only exceptions that **may** apply are: 
1) we are in a multi-threading setting
2) we know that the elements to store will grow and we know at which grade: with `Vector` we can set the increment value of the inner array