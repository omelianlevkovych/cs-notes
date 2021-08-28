# Designing data-intensive applications


- [Foundation of data systems](#foundation)
  - [Reliable, scailable, and maintainable apps](#three-fundamental-forces)
    - [Reliablility](#reliability)


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

```sh
docker run -d -p 8000:8080 --restart=always --cap-add=SYS_ADMIN --name=test <youruser>/dillinger:${package.json.version}
```
