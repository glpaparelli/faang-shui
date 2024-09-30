**TODO**





### Stream Parallelism
[[Java Streams]] also facilitate parallel execution: streams are pure functional and lazy evaluated, the order of evaluation do not matter, hence it can be parallelized.

```java
double average = pList 
	.parallelStream() // parallel stream
	.filter(p -> p.getGender() == Person.Sex.MALE) 
	.mapToInt(Person::getAge) 
	.average() 
	.getAsDouble();
```

The runtime suport takes care of using multithreading for parallel execution in a trasparent way (which is good for simplicitly, bad for debugging).
If the operatoins don't have side-effects the thread-safety is guaranteed even if non-thread-safe collections are used

The perallelism is integrated with everything we have seen
- concurrent mutable reduction is supported for parallel stream, there are suitable methods of `Collector`
- we can retrieve parallel stream from collections using `SplitIterator` which is an iterator on collections that support splitting data to allow parallel streams

#### When to use Parallel Stream
- when operatoins are indipendend and 
- either or both
	- operations are computationally expensive (for very light operations the cost to allocate threads and to do context switches could outweight the parallel speedup)
	- operations are applied to many elements of efficiently splittable data structures