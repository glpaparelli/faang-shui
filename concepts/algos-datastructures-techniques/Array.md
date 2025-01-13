**Things to look out during interviews:**
- duplicates are allowed? if so does this make the solution harder or easier?
- never go out of bounds
- be careful about slicing and concatenating arrays as they are $O(n)$

**Corner cases:**
- empty sequence 
- sequence with $1$ or $2$ elements
- sequence of repeated elements
- duplicate values in the sequence

**Techniques:**
1) **sliding window technique** that applies to many sub-array/strings problems. In a sliding window we usually have two pointers that move in the same direction and will never overtake each other. This ensure that each value is only visited at most twice. An harder version is the [[Notes from CP Course#17) Sliding Window Maximum|sliding window maximum]]. 
2) **traversing from the right:** sometimes you can traverse the array from the right to find a smarter solution
3) **two pointers:** more general version of the sliding window. Given two arrays to process, it is common to have one index per array (pointer) to traverse/compare the both of them, incrementing one of the pointers when relevant. For example, we use this approach to merge two sorted arrays. [[Notes from CP Course#Optimal Solution Two Pointers Trick, $O(n)$|two pointers example]]
4) **[[Array#Sorting|sorting]] the array:** is the array sorted or partially sorted? if it is, some form of [[Notes from CP Course#3) Binary Search|binary search]] should be possible. This also implies that the interviewer is looking for a solution that is faster than $O(n)$. Can you sort the array? Sorting often simplifies greatly the problem, but it gives you a base complexity of $O(n\log(n))$ 
5) **precomputation:** for questions where summation and multiplication of a subarray is involved, pre-computation using hashing or a prefix/suffix sum/product might be useful. [[Notes from CP Course#Smart Solution Precomputation, $O(n)$ time, $O(n)$ space|precomputation example]], [[Notes from CP Course#23) Prefix Sums|prefix sums]]
6) **index as a hash key:** if you are given a sequence and the interviewer asks for $O(1)$ space it might be possible to use the array itself as an hash table. For example if the array only has values from $0$ to $n-1$, where $n$ is the array's length, we can transform the array an hash table.
7) **traversing more than once:** sometimes traversing the array more than once can help you solve the problem while keeping the time complexity to O(n).

**Essential Questions:**
- [Two Sum](https://leetcode.com/problems/two-sum/)
- [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
- [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
- [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

**Recommended Practice Questions:**
- [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
- [Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
- [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)
- [3Sum](https://leetcode.com/problems/3sum/)
- [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
- [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)
### Sorting
**TODO**
