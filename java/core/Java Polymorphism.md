**Having several forms**, where "forms" are types, either primitive or user defined. 

Polymorphic are:
- **functions or methods:** we can give the same name to different methods and distinguish them by the number and or the type of their parameters
- **types**: parametric data types, type constructors or generics 
## Classification of Polymorphism
**There are two main categories of polymorphism:** 
1) **Ad Hoc**
2) **Universal**

**Mind that they are not mutual exclusive: we can have both at the same time.**

![[Screenshot from 2024-09-30 12-26-34.png | center | 700]]
## 1) Ad Hoc Polymorphism
 **With ad hoc polymorphism the same function name denotes different implementations.**
 The code to execute is determined by the actual types. 
### Overloading in Java
**Overloading:** same name for methods with the same logic. 

Concept present in all languages, at least built in for arithmetic operators such as `+`, `*`, ...
**Example:** In Java the `+` is the sum for numbers but also the concatenation for strings. 

**The code to execute is determined by the type of the arguments**, thus:
- [[Binding#Early Binding|Early Binding]] in statically typed languages
- [[Binding#Dynamic Binding|Dynamic Binding]] in dynamically typed languages **like Java.**

Which version execute is decided **on the number, types, and order** **of the parameters.**
Let's say that we want to implement: $f(x) = x^2$. 
Then we can simply overload the method `sqrt` to handle different cases:
```java
int sqr(int x){
	return x * x;
}
double sqr(double x){
	return x * x
}
```
#### Overloading by Return Type
**It is not allowed to overload based only on the return type** because it could lead to **ambiguity** during method invocation.

When you call a method, Java uses the method's **name and parameters** to determine which method to invoke, **using the method descriptor** ([[Java Virtual Machine#Method Data|Method Descriptor]]). 
**The return type is not part of this resolution process.**
Therefore, if two methods have the same name and parameters but different return types, Java won't know which method to call.

**Observation:** since Java allows `void` methods we see how things would be even more ambiguous if overloading by return type were allowed.
### Overriding in Java
A method `m()` of a class `A` can be redefined in a subclass `B` of `A`

```java
A a = new B(); //legal
a.m(); // the overridden method in B is invoked
```

The implementation of the subclass is always invoked first, as in Java we have [[Binding#Dynamic Binding|Dynamic Binding]] and [[Java Inheritance#Java Dynamic Dispatcher|Dynamic Dispatcher]]. 
#### Overriding by Return Type
As seen for overloading we cannot override a method by simply its return type. 
In case of overriding we have more margin as **it is possible to use covariant return types:** we can override a method of the superclass by returning an object that is a child of the return type of the superclass' method.

**Example:**
```java
class Animal {
    Animal getAnimal() {
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    // Covariant return type (Dog is a subclass of Animal)
    Dog getAnimal() {  
        return new Dog();
    }
}
```

**Mind that** if outside the covariant return type the **overriding only by return type is not allowed and result in a compilation error.**
## 2) Universal Polymorphism 
With **universal** polymorphism **there is only one algorithm**: a single (universal) solution that is applied to different objects. 
The call of the algorithm is type independent: it is the algorithm that can handle different types of arguments. 

In Java this kind of polymorphism is also achieved through [[Java Generics]]. 
**Specifically in Java we have universal -> parametric -> explicit -> bounded (invariant) polymorphism.**
### Coercion
**Coercion is the automatic conversion of an object to a different type.** 
**It is opposed to casting, which is explicit.** 

**If there is no loss of information the coercion is implicit**, as no harm can be done.
**If there is loss of information the casting has to be explicit:** the compiler can't take the liberty of destroying potentially useful info. 

**Example:**
```C
int x = 5; 
double dy = 3.14;

// coercion, "implicit casting", no info loss
double dx = x; 

//casting, potentially dangerous info loss
int y = (int) dy; 
```

Coercion can be used for polymorphism but it is a **degenerate and uninteresting case**
```C
double sqrt(double x){...}

//the par is an int, which is "coerced" to double
double d = sqrt(5); 
```
### Inclusion
Inclusion polymorphism is also known as **subtyping polymorphism**, or just **[[Java Inheritance|Inheritance]]**. 

The polymorphism is ensured by the **substitution principle.** 
**Substitution Principle:** an object of a subtype can be used in any context where an object of the supertype is expected. 

The substitution principle is based on the fact that **an object of the subtype has at least all the information**, as in fields and methods, of the superclass.

Java uses the substitution principle for classes: methods/functions with formal parameter of type `T` accept an actual parameter of type `S` $\leftarrow$ `T` (`S` subtype of `T`).
## Conclusion
As said **universal** and **ad hoc** polymorphism can coexists. 
In Java, for example, we have that: 
- **if an inherited method has been overridden**: then it is **ad hoc polymorphism**, since the signature is the same but the body is different
- **if an inherited method has been overridden:** then it is **universal polymorphism** because it's the same code (the code of the parent) that goes in execution