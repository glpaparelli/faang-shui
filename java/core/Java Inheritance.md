**Java Inheritance** is a fundamental object-oriented programming concept that allows one class (child or subclass) to inherit properties and behaviors (fields and methods) from another class (parent or superclass). This promotes code reuse, organization, and extensibility.
#### Superclass and Subclass:
The **superclass** is the class being inherited from.
The **subclass** inherits attributes and methods from the superclass and can also add new features or modify existing ones.
#### Keyword `extends` 
Used to create a subclass by inheriting from a superclass. 
**Example**:
```java
class Animal {
	// fields and methods
}

class Dog extends Animal {
	// Dog inherits Animal properties and methods 
}
```
#### Method Overriding:
A subclass can provide a specific implementation of a method already defined in its superclass.
The method in the subclass must have the same signature (name, return type, and parameters) as in the parent class.
#### Keyword `super`
Used to refer to the superclass's methods or constructors.
Useful for accessing overridden methods or invoking the parent class constructor.
#### Single and Multiple Inheritance
Java supports **single inheritance**, meaning a class can inherit from only one superclass directly.

**A class cannot extend more than one class** because it can lead to **the diamond problem:** 
![[Pasted image 20240930093709.png | center | 450]]
If an object of type `Z` call `methodX()` which method is called? The instance method of class `Z`, since we have Dynamic Dispatching. 
But if `Z` would not override `methodX()` and would call `super.methodX()` which implementation would be called?
**Java support multiple inheritance by supporting multiple implementations of interfaces: a class can implement more than one interface.**
#### `Object` Class:
Every class in Java implicitly extends the `Object` class, which is the root of the class hierarchy.
#### Why the Constructor of the subclass has to invoke `super()` as the first statement?
**TODO**
## Java Dynamic Dispatcher
**TODO**