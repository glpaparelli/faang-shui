Java conventions are essential coding standards that help developers write clear, maintainable, and error-free code. These conventions cover areas like naming, formatting, structure, and coding practices. Below is an overview of the main Java conventions:
### 1. Naming Conventions
Naming conventions ensure that Java code is easy to read and understand. Different types of identifiers (classes, methods, variables, etc.) follow specific rules:
- **Classes and Interfaces**:
    - **Convention**: PascalCase (UpperCamelCase)
    - **Example**: `MyClass`, `EmployeeDetails`, `RunnableInterface`
    - **Explanation**: Each word begins with a capital letter.
- **Methods**:
    - **Convention**: camelCase (lowerCamelCase)
    - **Example**: `calculateSalary()`, `findUserById()`
    - **Explanation**: The first word starts with a lowercase letter, and subsequent words start with an uppercase letter.
- **Variables**:
    - **Convention**: camelCase (lowerCamelCase)
    - **Example**: `employeeName`, `maxHeight`
    - **Explanation**: Similar to method names, the first word is lowercase.
- **Constants**:
    - **Convention**: UPPERCASE_WITH_UNDERSCORES
    - **Example**: `MAX_COUNT`, `PI`, `DEFAULT_TIMEOUT`
    - **Explanation**: All letters are capitalized, and words are separated by underscores.
- **Packages**:
    - **Convention**: lowercase
    - **Example**: `com.companyname.project`, `org.example.utility`
    - **Explanation**: Package names are in lowercase to avoid conflicts with class names.
- **Type Parameters (Generics)**:
    - **Convention**: Single capital letters
    - **Example**: `T`, `E`, `K`, `V`
    - **Explanation**: These letters represent generic types (e.g., `<T>` for type, `<E>` for element).
### 2. Formatting Conventions
Formatting ensures readability and consistency across the codebase:
- **Indentation**:
    - **Convention**: Use **4 spaces** per indentation level (avoid tabs).
- **Line Length**:
    - **Convention**: **80 to 120 characters** per line.
- **Braces**:
    - **Convention**: Open braces `{` are placed at the end of a line, not on a new line.
- **White Space**:
    - Use spaces around operators (`=`, `+`, `-`, `==`, etc.) and after commas in method calls or arrays.
    - Insert blank lines between methods and before class-level declarations.
### 3. Coding Conventions
These conventions are for writing efficient, bug-free code:
- **File Structure**:
    - One **public class** per file.
    - Filename should match the class name.
- **Method Length**:
    - Keep methods short and focused. If a method exceeds 30–50 lines, consider refactoring it into smaller methods.
- **Single Responsibility Principle**:
    - Each class should represent one concept or responsibility. If a class does too many things, consider splitting it.
- **Avoid Magic Numbers**:
    - Use named constants instead of hardcoded values.
    - Example: Instead of `if (age > 65)`, use `if (age > RETIREMENT_AGE)`.
- **Return Types and Parameters**:
    - Always specify return types explicitly, never leave out.
    - Example: Prefer `void` for methods that do not return a value.
- **Commenting**:
    - Write clear, concise comments. Focus on why something is done, rather than how it's done (the code should explain the "how").
    - Use Javadoc comments (`/** */`) for public methods and classes to describe their functionality.
- **Avoid Deep Nesting**:
    - Try to minimize nested loops or `if` conditions, as they reduce readability.
    - Consider using early returns (`return`) or breaking code into separate methods.
### 4. Access Modifiers
Use access modifiers to control the visibility of classes, methods, and variables:
- **Private** (`private`): Visible only within the class.
- **Protected** (`protected`): Visible within the package and subclasses.
- **Package-Private** (default, no keyword): Visible only within the package.
- **Public** (`public`): Visible everywhere.

More on [[Java Modifiers]]
### 5. **Exception Handling**
- **Use Checked Exceptions for Recoverable Conditions**:
    - For cases where the caller can reasonably recover, use checked exceptions (e.g., `IOException`).
- **Use Runtime Exceptions for Programming Errors**:
    - For cases like null pointers or array index out-of-bounds, which are due to programming errors, use unchecked exceptions (e.g., `NullPointerException`).
- **Never Suppress Exceptions**:
    - Always handle exceptions or rethrow them. Suppressing exceptions makes debugging difficult.
- **Finally Block**:
    - Always use `finally` to release resources (e.g., file handles, database connections).
### 6. **Best Practices for Code Design**
- **Immutability**:
    - Make objects immutable (unchangeable) whenever possible to improve safety and thread safety.
- **Use Interfaces Over Implementation Classes**:
    - Prefer programming to interfaces rather than implementations.
    - Example: Use `List` rather than `ArrayList` when declaring variables.
- **Avoid Long Parameter Lists**:
    - If methods require more than 3–4 parameters, consider refactoring to group them into objects.
- **Use `Enum` for Fixed Sets of Constants**
### 7. Java Documentation (Javadoc) Conventions
**Javadoc** comments are used to generate HTML documentation for classes, methods, and fields:
- Start with `/**` and end with `*/`.
- Tags like `@param`, `@return`, `@throws` should be used to describe method parameters, return values, and exceptions respectively.

**Example:**
```java
/**
 * Calculates the total salary of an employee.
 * 
 * @param baseSalary Base salary of the employee.
 * @param bonus Bonus received by the employee.
 * @return Total salary of the employee.
 * @throws IllegalArgumentException if baseSalary is negative.
 */
public double calculateTotalSalary(double baseSalary, double bonus) {
    if (baseSalary < 0) 
        throw new IllegalArgumentException("Base salary cannot be negative.");
    
    return baseSalary + bonus;
}
```
### 8. Threading and Concurrency Conventions
- **Synchronized Blocks**:
    - Use synchronized blocks carefully to avoid deadlocks. Prefer synchronizing at the smallest scope possible.
- **Use `java.util.concurrent`**:
    - When dealing with concurrency, prefer using high-level constructs from `java.util.concurrent` (like `ExecutorService`, `CountDownLatch`, etc.) instead of manually managing threads.

### 9. Unit Testing Conventions
- **Use `@Test` Annotation**:
    - Use `JUnit` or other testing frameworks and annotate test methods with `@Test`.
- **Naming Test Methods**:
    - Test methods should have clear names describing the scenario being tested.
    - Example: `shouldReturnTotalSalaryWhenValidInputs()`