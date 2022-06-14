# Object-Oriented Analysis and Design with Applications
It open your eyes on several important skills in the science and art of developing complex systems.  

Has 3 major sections:
- Concepts. Complexity of software and ways to manage it.
- Method. Method for the development of complex systems.
- Application. Five nontrivial examples of problem domains.

# Concepts
## Complexity
Read a bit more about ```abstractions```; it looks like people operates them pretty naturally.  
By the way, do not forget, that all that OOP, structural, FP thing is basically created only for us (humans). Computers
do not care about all that abstraction levels, they operate bites.  

The science of complexity calls this emergent behavior:  
```The behavior of the whole is greater than the sum of its parts```.


The industrial (enterprise) applications are actually complex.  
```The distinguishing characteristics of industrial-strength software is that it is intensely difficult, if not impossible,```
```for the individual developer to comprehend all the subtleties of the design.```.  
```The compexity of such systems exceeds the human intellectual capacity.```  
So? Well, you should aim to get the bigger picture
and have a skills to dig into details when it is really needed. Use abstraction as friend and not a foe.  


```The complexity of software is an essential property, not an accidental one```. It derives from:
- the complexity of the problem domain
- the diffuculty of managing the development process
- software will always grow and change, it brings compexity
- the problems of characterizing the behavior of discrete systems

five attributes of a complex systems:
- hierarchic structure
all systems have subsistems and all systems are parts of larger systems
- relative primitives
```what is primitive for one observer may be at much higher level of abstraction for another```
- separation of concerns
difference between intra- and intercomponent interactions provides a clear separation of concerns among the
various parts of a system, ``` making it possible to study each part in relative isolation```
- common patterns
hierarchic systems are usually composed of only a few different kind of subsystems in various combinations and
arrangements
- stable intermediate forms
as a system evolve, objects that were once considered complex become the primitive objects on which more complex
systems are built. Furthermore, we can never craft these primitive objects correctly first time: we must use them
in context first and improve them over time as we learn more about the real behavior of the system

