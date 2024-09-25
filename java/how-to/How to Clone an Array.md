**There are several ways to clone an array.**
In the following we list a few.
#### System.arraycopy()
Let's start with the core Java Library. 
`System.arraycopy()` copies an array from source array to a destination array, starting the copy action from the source position to the target position until the specified length. 

The number of elements copied to the target array equals the specified length. 
It provides an easy way to copy a subsequence o an array to another. 

**Example:** 
```java
int[] array = {1,2,3}; 
int[] copiedArray = new int[3];

// void arraycopy(src, srcPos, dest, destPos, lenght)
System.arraycopy(array, 0, copiedArray, 0, 3);
```
#### The Arrays Class
The Arrays class offer multiple ways to clone an array. 

 **Example 1: copyOf()**
```java
int[] array = {1,2,3,4};
// int[] copyOf(src, newLength)
int[] copiedArray = Arrays.copyOf(array, 4)
```

**Note:** 
`Arrays` uses `Math.min()` to get the minimum between the size of the source array and the passed new length to get the size of the new copied array.

**Example 2: copyOfRange()**
```java
int[] array = {1,2,3,4};
// int[] copyOf(src, from, to)
int[] copiedArray = Arrays.copyOfRange(array, 1, 4);
```
##### Beware of the Shallow Copy
Remember that both `copyOf` and `copyOfRange` **do a shallow copy** of objects if not applied on arrays of non-primitive types!

**Example:**
```java
		// shallow copy
        String[] sArray = {"ciao", "pippo", "pluto"};
		String[] sArrayCopied = Arrays.copyOf(sArray, 3);
		for(int i = 0; i < 3; i++)
            assertTrue(sArray[i] == sArrayCopied[i]); 

		// deep copy
		String[] sArrayDeepCopied = new String[3];
        for(int i = 0; i < 3; i++)
            sArrayDeepCopied[i] = new String(sArray[i]);

		for(int i = 0; i < 3; i++){
			// all false, not the same reference
            assertFalse(sArray[i] == sArrayDeepCopied[i]); 
            // all true, the same "string content"
            assertTrue(sArray[i].equals(sArrayDeepCopied[i])); // all true!
        }
```
#### Object.clone()
`Object.clone()` is inherited from the `Object` class: remember that arrays are objects.

**Example:**
```java
int[] array = {1,2,3};
int[] copiedArray = array.clone();
```

Mind that `array` and `copiedArray` are clones but they hold different references, editing one will not affect the other. 

Also remember that `clone()` create a shallow copy for non-primitive types, even if the enclosed object's class implements the `Clonable` interface and override `clone()`.
#### Stream API
We can also use the `Stream` API to clone arrays. 
Mind that it produce shallow copy of objects for non-primitive types.

```java
String[] sArray = {"ciao", "dog", "cat"};

/*
	<A> A[] toArray(IntFunction<A[]> generator)
	Returns an array containing the elements of this stream using
	the  provided generator function to allocate the returned array
	
	generator: a function which produces a new array of the desired type
*/
String[] sCopiedArray = Arrays.stream(sArray).toArray(String[]::new);
```