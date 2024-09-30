## Object Equality vs Functional Equality
- `==` checks the "**object equality**", it compares the reference or memory location of objects, whether they point to the same location or not. 
- `equals()` is for content equality or "**functional equality**"

**In simple terms:** 
`==` checks if both objects point to the same memory location whereas `.equals()` evaluates the comparison of the values "in" the objects!

**Observations:**
- `.equals()` is an inherited method. If no one in the hierarchy has redefined `equals()` 
   the method is the one from the ultimate parent class `Object`, which is by design the same as `==`
- when overriding `.equals()` one has to remember to override also `.hashCode()`.
   As per API the result returned from `.hashCode()` for two objects must be the same
   if their equals methods show that they are equivalent. 
   **The converse is not necessarily true.**
