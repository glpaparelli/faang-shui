in Java a string is an object that represents a sequence of characters or char values. 
The` java.lang.String` class is used to create a Java `String` object. 
#### Java String Pool
**The java string pool refer to collection of strings which are stored in heap memory.** 
In this, whenever a new object is created the JVM checks in the String pool whether
the object is already present in the pool or not. 
If it is present then same reference is returned to the variable. 

**Example:**
```java
String s = "hello";
String s2 = "hello";
assertTrue(s == s2); // true: s2 points to s!
```

If it is not present a new object is actually allocated and the reference is returned.
#### String Initialization
There are two ways to create a `String`: 
1) **string literals:** we can use the double quotes to create a `String`
	- `String s = "hello";`
2) **new String():** we can use the `new String()` 
	-  `String s = new String("hello");`

##### 1) **String Literals**
When you create a `String` using a **string literal**, like this:
```java
String s1 = "hello
```
- **Only one object** is created in the **String Pool** (part of the heap memory but a special section) if the string `"hello"` does not already exist in the pool. If `"hello"` is already in the pool, no new object is created; instead, `s1` will simply refer to the existing `"hello"` string in the pool.
- String literals are automatically **interned**, meaning Java will ensure that there is only one copy of each literal string in the pool.
##### 2) **new String()**
When you create a `String` using the `new` keyword:
```java
String s2 = new String("hello");`
```
- **Two objects** are created:
    1. One in the **String Pool** (if `"hello"` is not already there).
    2. Another **new object on the heap**, which is not part of the String Pool.
- The reference `s2` will refer to the object on the heap, not the one in the String Pool.
- In this case, even if `"hello"` already exists in the String Pool, the `new String("hello")` will explicitly create a separate object in the heap.
###### Why does the String Pool come into play even with `new String()`?
1. **String Pool Behavior**
    - The **String Pool** (also called the **interned string pool**) is a memory optimization mechanism in Java.
    - **When you pass a string literal** (like `"hello"`) to any string-related method (including the `new String()` constructor), the string literal **must** be placed (or referenced) in the **String Pool** first.
    - The Java compiler ensures that **all string literals** are either placed in or fetched from the pool. This happens for every string literal in the code.
2. **`new String()` behavior**
    - When you write `new String("hello")`, the `"hello"` string literal inside the constructor is processed **before** the `new String()` part.
    - **Before creating the new heap object**, Java checks if the `"hello"` literal is already in the **String Pool**. If `"hello"` is already in the pool, Java reuses the existing pooled string. If it's not in the pool, **it gets added to the pool first**.
    - **After this**, Java creates a **separate new object on the heap** for the `new String("hello")`, which is not the same as the pooled string.
###### Why is this necessary?
The key reason the **string literal** still gets placed in or referenced from the **String Pool** is that **Java always treats string literals the same way, regardless of how they are used**. Here’s why:
1. **Consistency in String Literal Handling**:
    - Java’s string literals are processed consistently: any string literal is either added to the pool or reused from the pool.
    - Even when used in `new String()`, the **literal** `"hello"` inside the parentheses is **treated as a literal** first, so it follows the rules of the String Pool.
    - This ensures uniformity and memory optimization for string literals throughout the program.
2. **String Interning and Pooling**:
    - The **String Pool** is designed to hold **unique literals**, making string reuse efficient in Java.
    - Even though you are using `new String()`, which creates a **distinct object on the heap**, the literal still follows the interning mechanism for consistency. This way, if `"hello"` is used elsewhere (as a literal), Java can reuse the pooled version
###### Key Example
```java 
String s1 = new String("hello");
```

Here’s what happens step by step:
1. **String Literal `"hello"`**:
    - `"hello"` is recognized as a **string literal**.
    - Java checks if `"hello"` already exists in the **String Pool**.
    - If it exists, it's reused from the pool. If not, Java places it in the pool.
2. **`new String("hello")`**:
    - Java then creates a **new object** on the heap, which is **not the same as the pooled version**.
    - The heap object is distinct, but the literal `"hello"` was processed via the pool.
###### Why not avoid the String Pool for `new String()`?
You might wonder why Java doesn't just skip the **String Pool** when using `new String()`. The reason is that **string literals must always be handled uniformly**:
1. **Uniform handling of literals**: The literal `"hello"` in the code is always processed as a string literal, regardless of context, so Java consistently treats it the same way for **optimization and reuse**.
2. **Memory efficiency**: If `"hello"` is used elsewhere in the program (like `String s2 = "hello";`), Java can ensure that `"hello"` is only stored once in the pool, while the separate object created by `new String()` remains independent.
3. **Consistency across APIs**: If you later call `.intern()` on a string created via `new String()`, Java can refer back to the **pooled version**. For example:
	- `String s1 = new String("hello"); String s2 = s1.intern();`
    In this case, `s2` will refer to the `"hello"` from the pool, while `s1` still refers to the distinct object in the heap.
###### Conclusion:
The reason Java processes the string literal in the **String Pool**, even when using `new String()`, is due to the consistent handling of **string literals** for memory efficiency, reuse, and interning. This allows Java to optimize memory for string literals, while still giving you the option to create new, distinct string objects on the heap when necessary.
#### Summary
- **String literals** create an object in the String Pool and reuse it.
- **`new String()`** creates an object in the heap and possibly one in the String Pool, leading to two objects in memory if `"hello"` didn't already exist in the pool.

This is important because `String` objects are immutable, and Java optimizes memory usage by reusing literals from the pool when possible.
#### Does it make sense to define a final String? 
"String are constant; their values cannot be changed after they are created"
Does this mean that a creating a `final String` is useless?

The `String` object is immutable **but the reference to that string can change.** 

**Example**: 
```java
String s = "hello";
```

Now, "hello" can not be changed in memory but we can reassign the value held by the 
variable `s`, to make it refer to a different string!
```java
s = "goodbye"

// this will produce "goodbye"
System.out.println(s);; 
```

On the other hand, If we create the following
```java
final String s = "hello";
```
Then `s` cannot even be reassigned to point to another string, the statement
```java
s = "goodbye";
```
will result in a compile-time error: "the final ... can not be reassigned". 

#### StringBuffer and StringBuilder
**TODO**