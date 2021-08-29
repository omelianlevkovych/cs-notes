# Designing data-intensive applications


- [Foundation of data systems](#foundation)
  - [Reliable, scailable, and maintainable apps](#three-fundamental-forces)
    - [Reliablility](#reliability)
    - [Scalability](#scalability)
    - [Maintainability](#maintainability)
        - [Operability](#operability)
        - [Simplicity](#simplicity)
        - [Evolvability](#evolvability)
- [Data models and query languages](#data-models-and-query-languages)
    - [The object-relation mismatch](#the-object-relation-mismatch)
    - [Relation vs document based](#relation-vs-document-based)


## Three fundamental forces
What is actually a data-intensive application? We call an application data intensive if data is its primary chellange, and not the CPU usage.  
Despite thinking about message systems, ORMs, etc as being very different they actually have _core_ things in common - all of them are **data systems**:
* Nowadays there are datastores that are also used as message queues (redis), and there are also message queues with database-like durability guarantees (kafka). The boundaries are blurred.
* Now many applications have such demanding or wide-ranging requirements that a single tool can no longer meet all of its data processing and storage needs. Instead, the work is broken down into tasks that can be performed efficiently on a single tool, and those different tools are stitched together using application code.

We are not only application developers anymore, we are **data-system designers**.
### Reliability
Reliability
It makes sense **only tolerate certain types of faults** (have a recovery process, error handling, etc). For instance, in case the black hole get planet Earth there should be servers outside the planet, good luck getting that budget item approved.  
**Fault is not a failure**. A fault is usually defined as one component of the system is not working.  
While a failure is when the system as a whole stops providing the required service to the user.  

**It is impossible to reduce the probability of fault to zero; therefore it usually best to design fault-tolerance mechanisms that prevent faults from causing failures.** https://netflix.github.io/chaosmonkey/  
Although we generally prefer tolerating faults over preventing them (in case that cure exists).

### Scalability
When dealing with the data-intensive application we can not say that system X is scalable or system X is not scalable, because it is not some one-dimension label that we can attach to the system.  
Rather we can cosinder some specific quesitons about our system, for instance, "In case our system growth in particular way, how we can handle that growth?" or "In case we would have some additional load soon, what computing resources we should add?".  
To answer such questions first thing that we should do is **describe load**.  
Load can be described with few numbers which we call **load parameters**. The best choice of parameters depends on your architecture: it can be requests/sec to a web server, the read/write ration to your db, the hit rate on a cache, etc.  
After you have managed to describe load you can go on and try to **describe performance**.  
The load and the performance are actually very tight connected, you can see it by answering the following question:  
When you increase a load parameter, how much do you need to increase the resources if you want to keep performance unchanged?  
Some of the performance parameters mayb be: _throughput number_ (total time it takes to run a job on a dataset of a certain size), _response time_ (the time the client is sending the request and receiving the response).
Because the _response time_ number can very from request to request, we therefore need to think of response time not as a single number, but as a _desctribution_ of values that you can measure. Strictly speaking, the avarage does not refer to any particular formula, but in practice it is usually understood as the arithmetic mean (add all n values and divide the sum by n). However the mean is not a very good metric, because it doesn't tell you how many users actually experienced some delay.
Usually it is better to use _percentiles_. p50

### Maintainability
We can and should design software in such a way that it hopefully minimize pain during maintainance, and thus avoid creating legacy software ourselves.  
#### Operability
The final goal is to make life easier for opearations (devops, support, maintain teams).  
"Good operations can somehow live with bad soft, however good soft cannot run reliably with bad operations".  
A good opeartions team typically is responsible  for the following, and more:
* Monotoring the health of the system and quick restoring service if it goes into a bad state
* Tracking down  the cause of problems, such as system failures or degraded performance
* Keeping software and it infrastructure up to date, including security patches
* Keeping tabs on how different systems affect each other, so that problematic change can be avoided before it cause damage
* Anticipating future problems and solving them before they occur
* Establishing good practices and tools for deployment, config management and more
* Performing complex maintaining tasks, such as moving an application from one platform to another
* Maintaining the security of system as config changes are made
* Defining processes that make operations predictable and help keep the prod env stable
* Preserving the org's knowleadge  about the system, even as individual people come and go  

Data systems can do various things to make routine tasks easy:
* Providing visability into the runtime behavior and internals of the system, with good monitoring
* Providing good support for automation and integration with standart tools
* Avoiding dependencies on individual machines (allowing machines to be taken down for maintenance while the system as a whole continues running uninterupted)
* Providing good docs and easy-to-understand operational model (if I do x than y will happen)
* Providing good default behavior, but also giving admins the freedom to override defaults when needed
* Self-healing where appropriate, but also giving admins manual control over the system state when needed
* Exhibiting predictable behavior, minimazing surprises  

#### Simplicity
Simplicity is all about **managing complexity**, and basicly means that we should make it easy for new engineers to understand the system, by removing as much complexity as possible from the system (this is not the same as simplicity of the user interface).  
A software proj mired in complexity in something described as _big ball of mud_.  
In complex software there is also a bigger risk to introduce bug when making change.  
One of the best tools we have to remove accidental complexity is **abstraction**. A good abstraction can hide a great deal of implementation details behind a clean, simple-to-understand facade. However, finding a good abstractions is utterly hard. In the field of distributed systems, there are many cool algos, it is much less clear how we should be packaging them into abstractions that help us keep complexity of the system at a managable level.  

#### Evolvability
Evolvability - making change easy.

## Data models and query languages
### The object-relation mismatch
Most apps development today is done in object-oriented approach, which leads to a common criticism of the SQL data model: if data is stored in relational tables, an awkward translation layer is required between the objects in the app code and the database model of tables, rows, and columns. The disconnect between the model is something called an **impedance mismatch**.  
ORMs help with that a bit but anyway they can't completely hide the difference between the two models.  
For instance lets take some mycv.app as an example (the application main feature is to store user resumes). In case of relational db you will proably have few tables like users, jobs, educations. In case of nosql db you can store cv in one place as a whole document. Here is when query problem comes into place: in cases user will want to get the data from the db, he will need to have multiple queries (to all that tables) or one big query with many Joins, however with nosql db you wont have such problems.
#### Relation vs document based
Document based:
* Schema flexibility
* Better performance due to locality
* For some apps it is closer to the data structures used by apps

Relational:
* Better support for joins
* Better many-to-one, many-to-many relationships

```sh
docker run -d -p 8000:8080 --restart=always --cap-add=SYS_ADMIN --name=test <youruser>/dillinger:${package.json.version}
```
