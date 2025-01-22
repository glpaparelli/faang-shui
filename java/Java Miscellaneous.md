### Division
**Java Performs TRUNCATION when dividing integers,** it drops the decimal part without rounding: `5/2 = 2`
### Inline list creation
There are two ways: 
1) `List<Integer> list = List.of(2,3);`
2) `List<Integer> list = Arrays.asList(2,3)`

There is only one difference between the two: the list created with `List.of` is **immutable**, while the list created with `Arrays.asList` is mutable if wrapped into another list implementation. 
### Finding the max from an int[] array 
Besides the obvious way we can use `Arrays.stream`: 
```java
int max = Arrays.stream(array).max().getAsInt();
```
- `getAsInt()` is necessary because `max()` return an optional from the stream. If the optional is empty `getAsInt()` throws `NoSuchElementException`. 

