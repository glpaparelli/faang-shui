#### Which two methods an Object must implemented to be used as a key in an HashMap?
In order to use any object as a key in `HashMap` the class must redefine `equals()` and `hashcode()`. 
#### What is an Immutable Object? Can You Write an immutable Object?
**Immutable classes are java classes whose objects can not be modified once created.** 
**Any modification in an immutable object result in a brand new object.** 
   
**Strings are immutable in Java**, and in fact a string can not be changed. 
Most of the times an immutable is also `final`: 
- An immutable class is immutable to prevent any sub-class to override methods that can compromise the immutability nature of the objects. 
- An object can be declared as `final` so that its reference can not be changed: 
	- e.g. `final String s = "hello"` 
		- can't modify the content of the String 
		- can't write `s = "another"` as `s` is `final`: it can only point to `"hello"`

Another way to achieve immutability is to make the members of the class private and never modifying them if not in the constructor. 
### Creating a String: new vs literals
- **new**: 
	- When we create a `String` with the `new` operator it is created in the heap and not added into the String Pool.
- **literal:**
	- When we create a `String` using a string literal the string in the String Pool itself, which exists in the `PermGen` area of the heap. 

More on this in [[Java String#String Initialization|String Initialization]]. 
#### What is the difference between StringBuffer and StringBuilder?
[[Java String#Mutable Strings StringBuffer and StringBuilder|StringBuffer and StringBuilder]]
#### What is the difference between ArrayList and Vector? 
[[ArrayList-vs-Vector|ArrayList vs Vector]] 
#### Design Patterns: Factory vs Abstract Factory
**TODO**
#### When you override hashcode() and equals()? 
**Whenever is necessary, main examples are:** 
- I want to use the object as a key in an `HashMap`
- I want to use  `.equals()` for comparing objects
- I want to use `.clone()` for cloning that object
#### When creating a Singleton it is better to synchronize the whole creation method or only its critical section? 
The smaller the synchronized part of the code is the better, so the answer is only the critical section.
#### If a method throws NullPointerException can we override it with a method that throws RuntimeException?
Yes, you can override the method with a method that throws any kind of [[Java Exceptions|exception]] that is higher in the hierarchy than `NullPointerException`. 
Mind that this can be done only with [[Java Exceptions#unchecked exceptions|unchecked exceptions]].
#### How do you ensure that n threads can access n resources without deadlock?
There are two main points: 
  1) **Make critical sections synchronized**
  2) **Order of resource acquisition:** 
	  1) The first thread that get a resource should be the first to release it
	  2) If you acquire resources in a particular order and release it in that order but reversed you can always prevent deadlock 
#### Differences between sleep() and wait()
- `sleep()` do not release the lock, while `wait()` releases the lock
- `sleep()` is in the `java.lang.Thread` class and hence it can be called on a `Thread` object while `wait()` is in the `java.lang.Object` class, thus it can be called on any object
- `sleep()` is interrupted only by exceptions or by the end of the passed time,  `wait()` can be interrupted using `notify()` or `notifyAll()`

**Clarification:**
Every object inherits the `wait()`and that is for inner-communication between threads. There is the **common mistake** to write `t.sleep(100)` because `sleep()` is an instance method of `Thread`, but sleep will pause the current running thread and not `t`
