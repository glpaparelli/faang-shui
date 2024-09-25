In Java 7 a class that implements an interface had to implement all the methods
defined in the interface. 
If you wanted to add a method to the interface (even an empty method) you had
to edit all the sub-classes, otherwise the code would not even compile. 

**Java 8 introduces Default Methods aka Defender Methods.** 
In an interface is possible to define a defender method using the keyword 
`default` and implement this method directly in the interface.
This method will be inherited by the implementing classes and it can even be overridden.

**TODO:** [[Java Lambdas]]
> they works thanks to the defender methods
> shorturl.at/tEGH0