JavaBeans are a kind of [[Software Components]] in Java and they are basically Java classes written in a standardized way. 
Beans are used to encapsulate multiple objects in one single entity (the bean) so that they can be passed and composed easly. 

*A Java Bean typically has a GUI representation.* 
*A Java Bean is a reusable software component that can be manipulated visually in a builder tool*

JavaBean is a platform-neutral component architecture for reusable software componets. 
A bean is a black box componet that is used to build larger components or applications. 

**Any Java class can be recognized as a bean in a tool, provided that**
- has a public default construct (no arguments)
	- a bean is made to be composed in a transparent way, you may not know what are the parameteres of the constructor
	- this is not limiting, it is possible to set/modify/customize the bean using setter methods
- implements the interface `Serializable`
- is in a jar file with manifest file containing `Java-Bean: True`
- all properties are private

### JavaBeans as Software Components
Beans are binary building blocks (compiled class files) and they are deployed insted of develped. 
Beans can be assebmled to build a new bean or a new application by writing the glue software to wire the beans together. 

#### Design Time vs Runtime
A bean must be able to run in the design envorioment of a builder tool providing means to the user to customize aspcet and behaviour of the bean itself. 
At runtime there is less need for customization. 
A possible solution is to have design-time information for customization and the runtime information separated, and at runtime only the runtime info are loaded (`<BeanName>BeanInfo.java`)

### JavaBeans Common Features
- **support for properties**: both for customization and for programmatic use
- **support for events**: simple communication metaphor that can be used to connect several beans
- **support for customization**: in the builder the user can customize the appearance and behaviour of the bean
- **support for persistance**: a bean can be customized in an application builder and then have its customized state saved away and reloaded later
- **support for introspection**: a builder tool can analyze how the bean works

### Simple Properties
A property is a set of discrete named attributes that can affect a bean instance's appearance or behaviour. 
A property can be changed at design-time (customization) or at runtime (application logic). 
A property $X$ and its type are determined by the tool through *introspection*

### Introspection
It is the process of analyzing the bean to determine its capability. It allows the tools to present the info (properties, type of the properites and how to change them) about a component to software designers. 

The class `<BeanName>BeanInfo` provide the information about the bean explicitly, if it is present there is no need for introspection.

Introspection is based on [[Java Reflection]], *naming convention* and [[Design Patterns]] and is inside the JavaBean API

From the two methods:
```java
public <PropertyType> get<PropertyName>();
public void set<PropertyName>(<PropertyType> a);
```
the tool infer the existance of a property called `propertyName` of type `propertyType`

If a property is an array, setter/getter methdis can take an index or the whole array: this is yet another convention to let the tool understands that the property is an array. 

From the following methods, by introspection, the builder infers the existence of a property `spectrum` of type `java.awt.Color[]`
```java
public java.awt.Color getSpectrum(int index);
public java.awt.Color[] getSpectrum();
public void setSpectrum(int index, java.awt.Color color);
public void setSpectrum(java.awt.Color[] colors)
```

### Connection-Oriented Programming 
A paradigm for gluing together components in a builder tool, based on the *Observer* (behavioral) [[Design Patterns]] which allow components to interact with each other in a non coupled way

#### Observer (aka Publish-Subscribe)
- **problem**: define a one-to-many dependency among objects so that when one object changes state all of its dependents are notified and updated automatically

In Java this pattern is based on *Events* and *Event Listeners*. An event is an object generated by an event source and propagated to the registered event listener. 

Based on methods for (un)registering listeners. 
From the following methods (by introspection) the tool infer that the object is source of an event, that the event name is `EventListType`
```java
public void add<EventListType>(<EventListType> a) {...}
public void remove<EventListType>(<EventListType> a)
```

*example*
```java 
public void addUserSleepsListener(UserSleepsListener lis) {...}
public void removeUserSleepsListener(UserSleepsListener lis) {...}
```
infer that the class generates a `UserSleeps` event

In Java we have multicast semantics by default: several possible listeners, the unicast semantics (at most one listener) can be enforced by tagging the event source (we put `throws TooManyListenerException` to the method that adds listeners)

##### Event Adaptors 
Placed between the event source and a listener: it behaves as a source to the listener and as a listener to the source. 

Adaptors are used to: 
- **asynchronous comunication**: implement an event queuing mechanism between sources and listeners
- **filtering**: Java distinguish events by the type (class), if we want to filter based on the info that the event carry we have to look inside the event itself with a filter adaptor
- ... 

### Bound and Constrained Properties
- a **bound property** generates an event when the property is changed
- a **constrained property** can only change value if none of the registered observers "poses a veto"

Mind that a property can be bound and constrained *at the same time* simply merging the respective implementations. 

#### Bound Properties
Bound properties generate an event when the property is changed. The event is of type `PropertyChangeEvent` and it is sent to objects that previously registered an insterest in receiving such notifications. 

- **event source**: bean with the bound property
- **event target**: bean implementing the listener

##### Implement Bound Property in a Bean
To implement the **event source** (the bean that have the bound property):
- **1**: import the package `java.beans` 
- **2**: instantiate a `PropertyChangeSupport` helper object 
```java
private PropertyChangeSupport changes = new PropertyChangeSupport(this)
```
- **3**: implement methods to maintain the property change listener list
```java
public void addPropertyChangeListener(PropertyChangeListener list){
	changes.addPropertyChangeListener(list)
}

public void removePropertyChangeListener(PropertyChangeListener list){
	changes.removePropertyChangeListener(list);
}
```
- **4**: modify a property's setter method to fire a property change event when the property changes
```java
public void setX(int newX){
	int oldX = this.x;
	this.x = newX;
	changes.firePropertyChange("x", oldX, newX);
}
```
- mind that here the property is a simple local variable but it might be a complex calculated varaible that involves function invocations
- if the instance methods modify x (and they could since they see it) they have to modify it through the setter method, otherwise we would have a change that do not fire an event

To implement the **event listener** (the bean that listen on the property)
- **1**: the listener have to implment the interface `PropertyChangeListener`
```java
public class MyListener implements PropertyChangeListener{ ... }
```
- **2**: the listener have to override the method inherited from the interface
```java
public abstract void propertyChange(PropertyChangeEvent evt)
```
- this is the method invoked by the helper on every listener registered in the listener list
**3**: register the listener as a listener to the property of the bean
```java
Button button = new MyButton();
MyListener lis = new MyListener();
button.addPropertyChangeListener(lis);
```

#### Constrained Properties
A constrained property generates an event when an attempt is made to change its value. The event type is `PropertyChangeEvent`, which is sent to objects that have previously registered an interest in receiving such notification. 
Those objects have the ability to veto the proposed change by rising an exception, this allows a bean to operate differently according to the runtime enviroment (on the context in which the bean is inserted)

##### Implement Constrained Property in a Bean
To implement the **event source**:
- **1**: import the package `java.beans`
- **2**: instantiate a `VetoableChangeSupport` object
```java
private VetoableChangeSupport vetos = new VetoableChangeSupport(this);
```
- **3**: implement methods to maintain the listener list
```java
public void addVetoableChangeListener(PropertyChangeListener list){
	vetos.addPropertyChangeListener(list)
}

public void removeVetoableChangeListener(PropertyChangeListener list){
	vetos.removePropertyChangeListener(list);
}
```
- **4**: write a property's setter method to fire a property change event
```java
public void setX(int newX){
	int oldX = this.x;
	try{
		vetos.fireVetoableChange("x", oldX, newX)
		//if no exception is raised the change is allowed
		this.x = newX
		//here fire a property change if the property is also bound
	} catch(PropertyVetoException e){
		// the change was rejected by somebody 
	}
}
```

To implement the **event listener**: 
- **1**: implements the `VetoableChangeListener` which has an abstract method `void vetoChange(PropertyChangeSupport evt)`
- **2**: override `void vetoChange(PropertyChangeSupport evt)` which will be called by the source bean on each object in the listener kept by the `vetoableChangeSupport` object
- **3**: if the listener wants to forbid the change described in `evt` it should raise a `PropertyVetoExcpetion`, otherwise simply return.