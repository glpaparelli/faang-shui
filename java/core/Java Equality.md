### Object Equality vs Functional Equality
**== vs .equals()**
- `==` checks the "**object equality**", it compares the reference or memory location of objects, whether they point to the same location or not. 
- `equals()` is for content equality or "**functional equality**"

**In simple terms:** 
`==` checks if both objects point to the same memory location whereas `.equals()` evaluates the comparison of the values "in" the objects!

Things can get tricky, e.g. [[Java String#String Equality|Strings Equality]]

**Observations:**
- `.equals()` is an inherited method. If no one in the hierarchy has redefined `equals()` 
   the method is the one from the ultimate parent class `Object`, which is by design the same as `==`
- when overriding `.equals()` one has to remember to override also `.hashCode()`.
   As per API the result returned from `.hashCode()` for two objects must be the same
   if their equals methods show that they are equivalent. 
   **The converse is not necessarily true.**
### String Equality
**Creating Strings can lead to tricky cases when checking equality.** 

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