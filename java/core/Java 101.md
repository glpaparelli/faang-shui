**Extra dumb list of main components of Java.**
### **Object-Oriented Programming (OOP) Concepts**
- **Class and Object**:
    - **Class**: A blueprint for creating objects, defining their properties (attributes) and behaviors (methods).
    - **Object**: An instance of a class. Objects hold state and behavior.
- **Encapsulation**: Wrapping data (attributes) and methods (behavior) together inside a class, with access restricted via [[Java Modifiers|Modifiers]] (`private`, `public`, etc.).
- **[[Java Inheritance|Inheritance]]**: A mechanism where one class (subclass) can inherit the properties and methods of another class (superclass). This promotes code reuse and logical hierarchy.
- **[[Java Polymorphism]]**: The ability of an object to take many forms. It can be achieved through:
    - **Method Overloading** (compile-time): Same method name with different parameters.
    - **Method Overriding** (runtime): Subclass provides a specific implementation of a method declared in the parent class.
- **Abstraction**: Hiding the complex implementation details and showing only the essential features. This can be achieved using abstract classes and interfaces.
### **Platform Independence**
**Write Once, Run Anywhere (WORA)**: Java code is compiled into bytecode using the Java compiler. This bytecode can run on any platform (Windows, Linux, etc.) that has a Java Virtual Machine (JVM) without needing to recompile the code for each platform.
### **Java Virtual Machine (JVM)**
The [[Java Virtual Machine|JVM]] executes the bytecode produced by the Java compiler. It provides a runtime environment and abstracts the platform specifics.
### **Memory Management**
**Garbage Collection**: Java automatically handles memory allocation and deallocation through its garbage collector, which cleans up unused objects to prevent memory leaks.
### **Exception Handling**
**[[Java Exceptions]]**: Java has a robust exception-handling mechanism to manage runtime errors. You can handle exceptions using `try`, `catch`, `finally`, and `throw`/`throws` to ensure graceful program termination.
### **Multithreading**
Java supports [[Java Multithreading and Concurrency|Multithreading]], which allows concurrent execution of two or more parts of a program to maximize CPU utilization. It provides built-in support for managing threads using classes like `Thread` or `Runnable`.
### **Platform Neutral and Secure**
- **Platform Neutral**: Java programs are independent of any specific machine or operating system, making them portable.
- **Security**: Java provides built-in security features like bytecode verification, sandboxing, and classloaders to prevent malicious code from running.
### **Java Development Kit (JDK) & Java Runtime Environment (JRE)**
- **JDK**: A software development kit required to write Java programs. It includes tools like the compiler and debugger.
- **JRE**: A subset of the JDK, required to run Java applications. It contains the JVM and runtime libraries but not the compiler or development tools.
### **Syntax and Semantics**
- **Strongly Typed Language**: Java requires explicit declaration of data types (e.g., `int`, `float`, `String`).
- **Code Structure**: Java enforces strict structure with classes, methods, and blocks defined by `{}`.
- **Main Method**: Every Java application starts its execution from the `main` method (signature: `public static void main(String[] args)`).
### **Data Types and Variables**
Java supports **primitive data types** (`int`, `char`, `float`, etc.) and **reference types** (objects and arrays).
**Type Casting**: Automatic and explicit casting of one data type to another.
### **Packages and Libraries**
Java supports modularity using **packages**, which organize classes and interfaces. 
The Java Standard Library provides a vast set of pre-built classes for I/O, networking, data structures, utilities, and more (e.g., `java.util`, `java.io`, `java.lang`).
### **Collections Framework**
Java provides the **[[Java Collections|Java Collections Framework]]** for handling groups of objects efficiently.

Key components include:
- **List** (e.g., `ArrayList`, `LinkedList`)
- **Set** (e.g., `HashSet`, `TreeSet`)
- **Map** (e.g., `HashMap`, `TreeMap`)
### **Interfaces and Abstract Classes**
- **Interface**: Defines a **contract** that a class must follow by providing method declarations but no implementation.
- **Abstract Class**: Similar to an interface but can include some method implementations along with abstract methods.
### **Input/Output (I/O) and Serialization**
[[Java IO]] provide extensive support for reading from and writing to files and streams (`java.io`, `java.nio`).

**Serialization:** allows objects to be converted into byte streams and saved or transferred, later to be reconstructed.
### **Annotations** 
Java allows developers to provide metadata about the program using [[Java Annotations]].
These can be used by compilers or tools for validation or code analysis.
### **Reflection**
[[Java Reflection]] provide the ability of a program to manipulate as data something representing the state of the program itself during its own execution. 