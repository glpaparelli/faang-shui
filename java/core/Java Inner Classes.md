**A Java inner class is a class defined inside the body of another class.**

A inner class can be declared `public`, `private`, `protected` or with default access 
whereas an outer class can only have `public` or `default` access. 

In Java the nested classes are divided into two types: 
- **static nested classes**
- **inner classes**
#### Static Nested Classes
If the nested class is static then it is called static nested class. 
This kind of class can access only the static members of the outer class
A static nested class is as any other top-level class and it is nested only for packaging convenience. 

**A static nested class is treated as any other nested member of the class.**
A static nested class's method is used as follow: 
```java
OuterClass.StaticNestedClass.staticMethod();
```
#### Inner Classes
**Any non-static nested class is known as inner class.** 

An inner class object in java is associated with the object of the outer class and it can access all the members of the outer class. 

Since the inner class is associated with the instance of the outer class, we can't have any static variable in them. 
The object of the java inner class is part of the outer class and to create an instance of the inner class we first need to create an instance of the outer class. 

A java inner class can be instantiated as follows:
```java
OuterClass outerObj = new OuterClass();
InnerClass innerObj = outerObj.new InnerClass();
```

There are two special kinds of inner class: 
1) **local inner class**
2) **anonymous inner class**
##### Local Inner Class
**If an inner class is defined in a method body then it is called local inner class.** 

**Clarification**
To be precise: **we can define a local inner class in any block**, but in this case the scope of the class will be very limited.

Since the local inner class is not associated with the instance of its outer class but with a block of it we can't use `private`, `public` or `protected` modifiers with it: the only allowed modifiers are `abstract` or `final`. 

A local inner class can see all the members of the enclosing class. 
It can also access and local variables that are in its scope, but it cannot modify them. 

**A local inner class can be defined as follows:** 
```java
public void print(){
	class Logger{
		// stuff
	}
	
	// instantiate Logger to use it in print
	Logger logger = new Logger(); 
	// stuff
}
```
##### Anonymous Inner Class
**A local inner class without a name is called anonymous inner class.** 

An anonymous inner class is defined and instantiated in a single statement. 
This classes always extend a class or implement an interface. 
Since an anonymous class has no name it is not possible to define a constructor for it. 
An anonymous inner class is accessible only in the point where it is defined.

**TODO**