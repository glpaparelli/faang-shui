The `var` keyword was introduced in Java 10 to exploit **type inference.**

We can declare any datatype with `var`, **but there are some rules:** 
1) `var` can be used to declare a local variable
2) `var` cannot be used in an instance or global variable declaration
3) `var` cannot be used as a generic type:
	- `List<var> list = new ArrayList<>()` will not compile
4) `var` cannot be used with generic types:
	 - `var<String> list = new ArrayList<>()` will not compile
5) `var` can be used to declare generic data structures: 
	- `var list = new ArrayList<String>()` is allowed
6) `var` cannot be used without explicit initialization
7) `var` cannot be used with lambda expressions
8) `var` cannot be used for methods parameters or return types