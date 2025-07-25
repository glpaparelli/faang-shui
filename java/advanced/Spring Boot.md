**Spring** is a powerful, open-source **Java framework** primarily used to build **enterprise-level** and **web applications**. It provides comprehensive infrastructure support for developing Java applications.

**Key features of Spring:**
- **Dependency Injection (DI):** Makes code more loosely coupled and easier to manage.
- **Aspect-Oriented Programming (AOP):** Allows separation of cross-cutting concerns (like logging, security).
- **Modular:** You can use just what you need (e.g., Spring Core, Spring MVC, Spring Data).
- **Transaction Management:** Simplifies database transactions.
- **Integration:** Works well with various technologies like Hibernate, JPA, JMS, etc.

--- 
### **Spring Boot**
**Spring Boot** is a **project built on top of the Spring Framework** that simplifies the development of Spring-based applications by reducing boilerplate code and configuration.
**Key features of Spring Boot:**
- **Auto-configuration:** Automatically configures application components based on classpath settings.
- **Standalone:** Can run without needing a full application server (uses embedded servers like Tomcat).
- **Production-ready features:** Includes metrics, health checks, and externalized configuration.
- **Opinionated defaults:** Provides sensible defaults to help developers get started quickly.
- **Spring Boot Starter Dependencies:** Bundles of dependencies for common use cases (e.g., `spring-boot-starter-web`).

#### Spring MVC

Spring **Model View Controller** is a part of the spring framework to help us build web application. 
It provides a clean way to separate components of our web application making it easier to manage and scale. 

- **Model:** Data + Logic
	- it represent the business logic of the application
	- usually connected with a database 
- **View:** what the users see
	- html, css and javascript
- **Controller:** Mediator
	- handle incoming request from the users
	- interact with the Model to get data
	- tells the View what to display
