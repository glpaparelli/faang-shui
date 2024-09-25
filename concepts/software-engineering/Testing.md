**Test kinds as fast as possible.** 
#### Unit Test
**Unit tests are very low level and close to the source of an application.** 
They consist in testing individual methods, modules, and basic the single units of code, hence the name. 
**They are very easy to automate:**
   - [[How to use Maven]] offer the possibility to run all the tests before compiling
   - IDEs often have a button that run all the tests
   - automatize through [[Java Reflection]]
   - ...
#### Integration Test
**Integration tests verify that different modules or services used by your application work well together.**
This kind of tests are more expensive to run since they require multiple parts of the application to be up and running
#### Functional Test
**Functional tests focus on the business requirements of the application.** 
They only **verify the output of an action and do not check the intermediate states of the system when performing that action**
##### Functional Test vs Integration Test
There is sometimes a confusion between integration tests and functional tests as they both require multiple components to interact with each other. 
The difference is that an integration test may simply verify that you can query
the database while a functional test would expect to get a specific value from
the database, as defined by the product requirements.
#### End-to-End Test
**End-to-end testing replicates a user behavior with the software in a complete application environment.** It verifies that various user flows work as expected and can be as simple as loading a web page or complex as verifying mail notifications, ...
#### Acceptance Test
Acceptance tests are formal tests that verify if a system satisfies business requirements. They require the entire application to be running while testing and focus on replicating user behaviors. 
They can also go further and measure the performance of the system and reject changes if certain goals are not met.
#### Performance Test
**Performance tests evaluate how a system performs under a particular workload.** 
These tests help to measure the reliability, speed, scalability and responsiveness of the application. 
#### Smoke Test
Smoke tests are basic test that check the basic functionality of an application. 
They are meant to be quick to execute and their goal is to give you the assurance that the major features of your system are working as expected.