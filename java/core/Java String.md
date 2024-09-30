in Java a string is an object that represents a sequence of characters or char values. 
The` java.lang.String` class is used to create a Java `String` object. 
## Java String Pool
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

**In other words:**
The **String Pool** is a memory optimization mechanism in Java.
When you pass a string literal (like `"hello"`) to any string-related method (including the `new String()` constructor), the string literal **must** be placed (or referenced) in the String Pool first.
The Java compiler ensures that **all string literals** are either placed in or fetched from the pool. This happens for every string literal in the code.
## String Initialization
There are two ways to create a `String`: 
1) **string literals:** we can use the double quotes to create a `String`
	- `String s = "hello";`
2) **new String():** we can use the `new String()` 
	-  `String s = new String("hello");`

#### 1) **String Literals**
When you create a `String` using a **string literal**, like this:
```java
String s1 = "hello
```
- **Only one object** is created in the **String Pool** (part of the heap memory but a special section) if the string `"hello"` does not already exist in the pool. If `"hello"` is already in the pool, no new object is created; instead, `s1` will simply refer to the existing `"hello"` string in the pool.
- String literals are automatically **interned**, meaning Java will ensure that there is only one copy of each literal string in the pool.
#### 2) **new String()**

```java
String s = new String("hello");`
```
When you create a `String` using the `new` keyword **two objects** are created:
- One in the **String Pool** (if `"hello"` is not already there).
- Another **new object on the heap**, which is not part of the String Pool.

When `new String("hello")` is called the `"hello"` string literal is processed before the `new String()` part.
Before creating the new heap object, Java checks if the `"hello"` literal is already in the String Pool. 
If `"hello"` is already in the pool, Java reuses the existing pooled string. If it's not in the pool, it gets added to the pool first.
After this, Java creates a **separate new object on the heap** for the `new String("hello")`, which is not the same as the pooled string.
The reference `s` will refer to the object on the heap, not the one in the String Pool. 
In this case, even if `"hello"` already exists in the String Pool, the `new String("hello")` will explicitly create a separate object in the heap.

**Why Java doesn't just skip the String Pool when using new?**
The reason is that string literals must always be handled uniformly, in other words: **Java always treats string literals the same way, regardless of how they are used**.
And, even if it is inside a constructor, `"hello"` remains a string literal.

**This approach might seem inelegant but has its perks:**

**1. Memory efficiency**: 
If `"hello"` is used elsewhere in the program (like `String s2 = "hello";`), Java can ensure that `"hello"` is only stored once in the pool, while the separate object created by `new String()` remains independent.

**2. Consistency across APIs**: 
Consider the behavior of the method `.intern()` on a string `s`: 
- if `s` is already in the string pool it return the reference to the pool
- if `s` is not in the string pool it adds `s` in the pool and return the reference to it

If you call `.intern()` on a string created via `new String()`, Java can refer back to the **pooled version**. 
**Example:**
```java
String s1 = new String("hello"); 
String s2 = s1.intern();
```
In this case, `s2` will refer to the `"hello"` from the pool, while `s1` still refers to the distinct object in the heap.
## Does it make sense to define a final String? 
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
## String Equality
**Creating Strings can lead to tricky cases when checking [[Java Equality]].** 
The trickiness derives from the fact that Strings are immutable, but their reference is not.

**Example 1: Simple Checks**
```java
public static void main(String[] args){
	String s1 = "hello"; 
	String s2 = s1; 
	String s3 = "hello";
	
	String s4 = new String("hello");
	String s5 = new String("hello");

	// s1 == s2 as s2 = s1, s2 points to the same are as s1
	assertTrue(s1 == s2);

	// s1 == s3 as "hello" was already in the String Pool!
	assertTrue(s1 == s3); 

	// s4 != s5 as they are different references, using new 
	// s4 and s5 explicitly points to newly created objects in the heap
	assertFalse(s4 == s5); // false!

	// s1.equals(s2) as they point to the same memory 
	// content,  hence the content is the same
	assertTrue(s1.equals(s2)); 

	// s1 and s4 content is the same ("hello")
	assertTrue(s1.equals(s4);
}
```

**Example 2: Tricky Checks**
```java
public final class A{

   public static String s; 
   public A(){
      this.s = "hello";
   }
}

public final class B{
   public String B; 
   public B(){
      this.s = new String("hello");
   }
}

public static void main(String[] args){
   A a1 = new A();
   A a2 = new A();

   assert(a1 == a2); // error, a1 and a2 are two different objects
   assert(a1.s == a2.s); // ok: s is static, and both objects points to s
   assert(a1.s.equals(a2.s)); // ok: both strings says "hello"

   B b1 = new B();
   B b2 = new B(); 

   assert(b1 == b2); // error: b1 and b2 are two different objects
   assert(b1.s == b2.s); // error: two different strings in memory
   assert(b1.s.equals(b2.s)); // ok: both strings says "hello" 
}
```
## Mutable Strings: StringBuffer and StringBuilder
In Java, both `StringBuffer` and `StringBuilder` are classes used to efficiently handle and manipulate mutable sequences of characters, i.e., strings that can be changed after they are created.
#### StringBuffer
The main characteristic of StringBuffer are **mutability** and **thread safety.**

**1) Mutability**: `StringBuffer` objects are mutable, meaning that the content of the string can be modified after it is created.

**2) Thread Safety**: `StringBuffer` is **synchronized**, which means it is **thread-safe**. 
Multiple threads can use the same `StringBuffer` instance without causing inconsistent results. However, this synchronization can result in slower performance in a single-threaded environment due to the overhead of acquiring and releasing locks.

**Use `StringBuffer`** when thread safety is essential: [[Java Multithreading and Concurrency]]. 

**Example:**
```java
StringBuffer sb = new StringBuffer("Hello");
sb.append(" World");
System.out.println(sb);  // Output: Hello World
```
#### StringBuilder
`StringBuilder` allows the mutation of strings as `StringBuffer` but it is not thread safe. 
In other words: `StringBuilder` is **not synchronized.**

**Use `StringBuilder`** when performance is more important and you're working in a single-threaded environment.

**Example:**
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb);  // Output: Hello World
```
