Every language $L$ implicitly defines an **abstract machine** $M_L$ that have $L$ as machine language. 
Implementing $M_L$ on an existing host machine $M_O$ (by compilation, interpretation or both) makes the programs written in $L$ executable.

Given a programming language $L$, an abstract machine $M_L$ for $L$ is a collection of data structures and algorithms which can perform the storage and execution of programs written in $L$. 

**A prime example of abstract machine [[Java Virtual Machine]].**

**Typically an abstract machine $M$ is implemented over a host machine $M_H$ which we assumed as already implemented.**
The components of $M$ are realized using data structures and algorithms implemented in the machine language $M_H$ .

**There are two main cases:**
- the interpreter of $M$ coincides with the interpreter of $M_O$
	- $M$ is an extension of $M_O$
	- other components of the machines may differ
- the interpreter of $M$ is different from the interpreter of $M_O$
	- $M$ is interpreted over $M_O$
	- other components of the machines may coincide 
## Java: Compilation + Interpretation
A two step process where the code is first compiled into an intermediate language and then the intermediate language is interpreted. 

- program written in $L$ (Java) + input
	- compiler from $L$ to an intermediate language $L_I$  (bytecode) where the compiler can be written in any language $L_A$ and it is executed on an abstract machine $M_A$ 
		- program written in $L_I$ (bytecode) is interpreted by the $L_I$ interpreter (JVM) written in $L_O$ and executed on $M_O$ 
			- output

**This mixed schema with intermediate abstract machine have notable advantages**
- **portability:** compile the Java source, distribute the bytecode and execute it on any platform equipped with the JVM.
- **interoperability:** for a new language $L$ just provide a compiler that translate to bytecode and then let it run on the JVM,  exploiting all the libraries and technology built so far