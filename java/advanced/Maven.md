**Built tool to compile, run tests, package the application in .jar, handle dependencies, plugins, etc.**
Another thing that maven does is to build pre-structured application skeletons based on archetypes.  This can be done directly from vs code and generate a basic "empty" project by "no archetype" option.

Every Maven project has some info that need to be decided: 
- **groupId:** 
	- The **Group ID** (`groupId`) is a unique identifier that represents the group or organization that produces the project.
	- **It follows a reverse domain name notation,** similar to Java package names.
	- `com.<your-name-or-company>.<project-name>`
- **artifactId:**
	- The **`artifactId`** is the name of your project or module. 
	- It uniquely identifies your project **within the groupId** and is used when generating build artifacts (like JAR or WAR files).
	- It is normal and often recommended that the artifcatId coincides with the project name of the groupId
- **version:** 
	- the **`version`** property specifies the version of your project (artifact)
	- there are **conventions:**
		- **`1.0.0`** (Initial Release): When you create a brand-new project or are releasing the first stable version.
		- **`1.1.0`** (Minor Updates): For smaller changes, such as adding new features or making non-breaking changes.
		- **`1.0.1`** (Patch): For bug fixes, minor improvements, or non-breaking changes that don’t add new features.
		- **`2.0.0`** (Major Version): For significant changes, including breaking changes or major new features that require downstream projects to adapt.
	- there are **keywords:**
		- `SNAPSHOT:`
			- e.g. `1.0.0-SNAPSHOT`
			- Indicates a **development version** of the project that is still in progress and subject to change. It’s not yet a stable or final release.
			- Maven will fetch the latest version of the `SNAPSHOT` each time a build is performed, meaning that a `SNAPSHOT` version can be updated frequently.
		- `alpha`: 
			- e.g. `1.0.0-alpha`
			- The **early stage** of a version, often released to test new features. It’s typically **unstable** and may not have all features completed. 
		- `beta`:
			- e.g. `1.0.0-beta`
			- Used to get user feedback and perform testing, although it should not be used in production environments.
		- `rc`: Release Candidate
			- e.g. `1.0.0-rc1`
			- Close to the final version, but still under review or testing for any remaining issues.
		- `final`:
			- e.g. `1.0.0-final`
			- indicates that the version is a **stable, production-ready release**.

The combo of `groupID`, `artifactID`, and `version` is often referred as the Maven **GAV**
#### Maven 101
Besides using vs code to create maven projects, you can do stuff by command line. 

To create a maven project using an archetype for simple, empty java application you type: 
```
mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart
```
and insert all the info required (`groupID`, ...). 

Then, once you have written your code, you move to the folder of the maven project (the folder has the name of the `artifactID`) and then type `mvn compile`.  
You can also type `mvn test` to compile and execute all the test classes. 
The instruction `mvn clean` remove all the compiled classes (empty the `target` folders). 
When the code compile without problems and even passes every test we might want to produce an "executable". Using `mvn package` creates a `.jar` file. 
The `.jar` file name is the concatenation of the `artifcatID` and the `version` property.

On your machine there is a local maven repository with many files. If you type `mvn install` in a maven project folder the project gets compiled, tested, packaged and added to the said local repository. 
This way, if another project need some stuff from this project he can access it without problems.

The command `mvn validate` checks that your project ticks all the maven expected boxes.
#### Handling Dependencies
**todo**
#### Versioning using Maven & GitHub
After modifying the source code: 
- set the `version` in the `pom.xml` file 
- commit and push changes in the remote repository
- **tagging the version:** to mark a specific version in git and create a clear point of reference for that release, you create a **Git Tag**
	- after committing, you create a tag:
		- `git tag -a v1.1.0 -m "message associated with the tag"`
	- `-a` stands for annotated, adds info the the tag such as the date, the author, etc
- **continuous integration:** later on
