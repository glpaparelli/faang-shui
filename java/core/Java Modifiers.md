**Simple review of all the modifiers.**
Modifiers are divided in two groups:
1) **access modifiers:** controls the access level
2) **non-access modifiers:** provide other functionality
#### Access Modifiers
- **for Classes:**
	- **public:** the class is accessible by any other.
	- **default:** without any keyword before declaring a class, the class is accessible only by classes in the same package. 
- **for Attributes, Methods and Constructors**
	- **public:** the code is accessible for all classes
	- **private:** the code is accessible only within the declared class
	- **protected:** the code is accessible by classes in the same package and by its sub classes.
	- **default:** without any keyword, the code is accessible only in the same package.
#### Non Access Modifiers
- **for Classes:**
	- **final:** the class cannot be inherited by other classes
	- **abstract:** 
		- The class cannot be used to create objects. 
		- To access an abstract class it must be inherited from an another class. 
		- An `abstract` class is kinda an interface: declare methods `abstract` and leave the implementations to the sub-classes or implement the method in the abstract class and this implementation will be inherited by the sub-classes.
- **for Attributes and Methods:**
	- **final:** attributes cannot be modified, methods cannot be overridden
	- **static:** attributes and methods belongs to the class, not to the single instance of the class 
	- **abstract:** as defined for classes
	- **transient:** attributes and methods are skipped when serializing the object
	- **synchronized:** methods can only be accessed by one thread at a time
	- **volatile:** the value of an attribute is not cached thread-locally, and is always read from the "main memory"