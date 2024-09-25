**Similar to Haskell "Some".** 
The main benefit of `Optional` is to avoid the `NullPointerException`. 
`Optional<String> s` is an object that may contain a `String` or it has "a null
meaning" without the risk of generating the exception. 

**We can create an Optional as follow:**
```java
Optional<String> s = Optional.of("hello");
```
The `.of(`) can't be `null`. 

If we want to create an empty `Optional` we do: 
```java
Optional<String> empty = Optional.empty(); 
```

if we want to create an Optional that wraps a `null` we can actually do:
```java
Optional<String> s = Optional.ofNullable(null);
```

The method `isPresent()`returns `true` if the value inside the optional object is present. 
If we created an `Optional` with `.ofNullable(null)`, then: 
- `isPresent()` will return `false`, since no value is present inside the optional object
- `isEmpty()` will return true, since inside we have null, which is nothing