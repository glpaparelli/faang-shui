**An exception is an unwanted or unexpected event, which occurs during the execution of a program.** 

There are two types of exceptions: 
1) **checked**
2) **unchecked**
#### Checked Exceptions
**A checked exception in Java represents a predictable, erroneous situation that can occur even if a software library is used as intended.** 

**Example:**
A developer tries to access a file: the Java IO library forces them to deal with the checked exception `FileNotFoundException`. 
The developers of the Java IO API anticipated that attempting to access a file that does not exist would be a relatively common occurrence, so they created a checked exception to force a developer to deal with it.

**These are the exceptions that are checked at compile time.** 
If some code within a method throws a checked exception then the method must either handle the exception or it must specify the exception using the keyword `throws`.

**In checked exception there are two types:** 
- **fully checked:** 
	- all the children of a fully checked exception are also checked. 
		- `IOException` is an example of fully checked exception. 
- **partially checked:** 
	- not all the children of a partially checked exception are checked exception. 
	- `Exception` is partially checked since some of its child are fully checked and others are not checked. 
#### Unchecked Exceptions
**In contrast to a checked exception, an unchecked exception represents an error**
**in programming logic**, not an erroneous situation that might reasonably occur
during the proper use of an API.

**Because the compiler can't anticipate logical errors that arise only at runtime, it can't check for these types of problems at compile time.** 
That's why they are called "unchecked" exceptions.

In Java, exceptions under `Error` and `RuntimeException` are unchecked exceptions, while everything else under `throwable` is checked. 

**Examples:**
  - `NullPointerException`, 
  - `IllegalArgumentException`
  - ...

These exceptions are not checked at compile time, and in fact the IDE will never tell you that a statement will throw that exception. 