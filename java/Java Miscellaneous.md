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

### Remove all non-alphanumeric chars from a String
```java
s = s.replaceAll("[^a-zA-Z0-9]", "");
```
### Put all the characters of a String in a set
Given `String s` and `HashSet<Character> set` to insert in `set` all the chars of `s`.
There are **many ways** to do it.

**classic for**
```java
for (int i = 0; i < s.length(); i++)
	set.add(s.charAt(i));
```

**for each**
```java
for (char c : s.toCharArray[])
	set.add(c)
```

**stream forEach**
```java
s.chars().forEach(ch -> set.add(char) ch);
```

**streams and Collectors**
```java
s.chars().mapToObj(ch -> (char) ch).collect(Collectors.set());
```

My favorite is the `forEach` as I find it the most clear to read.
The best is probably the one that use `collect`.