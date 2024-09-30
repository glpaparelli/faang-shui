**A very fast and dumb reminder of binding**

**Binding**: the process of association between a name (identifier) and an expression. 

Here we talk about the **binding of functions:** the process of association between the function name and the actual implementation that has to be executed. 

The binding of the function name with the actual code can be done at 
- **compile time**: *early binding* (aka static binding)
- **execution time**: *dynamic binding* (aka late binding)
### Early Binding
**If the language is statically typed the binding is done at compile time.** 
### Dynamic Binding
**If the language is dynamically typed the binding is done at runtime binding.**
The binding is done at runtime based on the types of the actual arguments / the most specific type used for the method invocation.

**Java uses dynamic binding**: while it might be possible to use early binding in some cases, overriding with sub-classes and [[Java Generics]] are bound to runtime information. 
**Example:**
```Java
// Given the Class A with two subclasses, B, C
A a = null;
if(something)
	a = new B();
else 
	a = new C();
```
It is clear that the type of `a` is determined at runtime, depending on which branch of the `if`
statement is executed.

