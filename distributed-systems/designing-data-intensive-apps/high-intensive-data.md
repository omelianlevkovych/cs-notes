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
* schema on read only (implicit and the application code do need to have some structure)

Relational:
* Better support for joins
* Better many-to-one, many-to-many relationships
* schema on write and read queries

Document dbs are sometimes called _shemaless_, but that's misleading, as the code that reads the data usually assumes some kind of structure - there is an implicit schema, but it is not enforced by the database.  
Schema on read is similar to dynamic (runtime) type checking in programming languages, whereas schema on write is similar to static (compile-time) type checking.

### Query language for data
SQL is declerative (you say to db what result you want).  
IMS, CODASYL is imperative (like almost all programming languages, you say every step you want to perform).  
Yes the declerative language is more stricted, and have more limitations, but it is more easier to work with and more concise. And even more important part, it also hides implementation details of the db engine, which makes it possible to the db to introduce performance improvements without requiring any changes to queries. For example, in the implerative code like this: 
```sh
function getAdmins(users) {
    var admins = [];
    for (int i = 0; i < users.length; ++i) {
        if (users[i].role == Roles.Admin) {
            admins.Add(users[i]);
        }
    }
    return admins;
}
```
the list of users appears in a particular order. If the db wants to reclaim unused disk space behind the scenes, it might need to move records around, changing the order in which the animal appear. Can the db do that safely without breaking queries?  
The SQL (for instance it will be SELECT query in this case) does not guarantee any particular ordering, and so it doesn't mind if the order changes. But if the query is written in imperative way, the db can never be sure whether the code is relying on the ordering or not. The fact that SQL is more limited in functionality gives the database much more room for optimatic optimization.  
Finally, the declarative languages often lend themselves to parallel execution. Imperative code is very hard to parallelize across multiple cores and multiple machines, because it specifies instructions that must be performed in a particular order. Declerative languages have a better chance of getting faster in parallel execution because they specify only the pattern of the result, not the algo that is used to determine the result.

#### Declerative query on the web
The adventage of declerative languages are not limited just to dbs.  
Imagine you have the following example:  
```sh
<ul>
    <li class="selected">
        <p>Admins</p>
        <ul>
            <li>SuperAdmin</li>
            <li>SuDo</li>
            <li>OrganizationAdmin</li>
        </ul>
    </li>
</ul>
```

Now lets say you want the title of the current selected page to have a red background. This is easy using the CSS:  
```sh
li.selected > p {
    background-color: red;
    }
```
From here you can see that CSS is a declerative language.  
Just imagine how tough life would be like if you had to use an imperative approach:  
```sh
JS DOM API:  
var liElements = document.getElementByTagName("li");
for (var i = 0; i < liElements.length; ++i) {
    if (liElements[i].className == "selected") {
        var children = liElements[i].childNodes;
        for (var j = 0; j < children.length; ++j) {
            var child = children[j];
            if (child.nodeType === Node.ELEMENT_NODE && child.tagName === "p") {
                child.setAttribute("style", "background-color: red");
            }
        }
    }
}
```
Except the fact that above code is less readable (more awful), it also has some serious problems:
* If the selected class is removed the blue color won't be removed, even if the code is rerun - and so the item will remain highlited until the entire page is reloaded. With CSS, the browser automatically detect when the _li.selected > p_ rule no longer applies and removes the red background as soon as selected class is removed.
* If you want to take advantage of the new API, such as document.GetElementByClassName("selected") or even document.evaluate() - which may improve performance - you have to rewrite the code. On the other hand, browser vendors can improve the performance of CSS without breaking compatibility.

#### MapReduce Querying
*MapReduce* is a programming model for processing large amounts of data in bulk across many machines, popularized by Google.  
A limited form of MapReduce is supported by some NoSQL dbs, including MongoDb and CouchDb, as a machanism for performing read-only queries across many docs.  
MapReduce is neither a declerative language or a fully imperative query API, but somewhere in between: the logic of the query is expressed with snippets of code, which are called repeatedly by the processing framework. It is based on _map (collect)_ and _reduce (fold, inject)_ functions that exist in many functional programming languages.  
The map and reduce must be a _pure_ functions which means they only use the data that is passed to them as input, they cannot perform additional db queries, and they must not have additional side effects. These restrictions _allow the database to run the functions anywhere, in any order, and rerun them on failure_.  
The moral of this story is that a NoSQL system may find itself accidentaly reinventing SQL, albeit in disguise.

### Graph-like data models
In case you have a lot of many-to-many relationships.
#### Property graph model
Implemented by Neo4j, Titan, InfiniteGraph.  
In the property graph model, each vertex (dot) consist of:
* A unique identifier
* A set of outgoing edges
* A set of incoming edges
* A collection of properties (key-value pairs)

Each edge consists of:
* A unique identifier
* The vertex at which the edge starts (the _tail vertex_)
* The vertex at which the edge ends (the _head vertex_)
* A label to describe the kind of relationship between the two verticles
* A collection of properties (key-value pairs)

How it would be implemented in relational schema:
```sh
CREATE TABLE  verticles (
    vertex_id integer PRIMARY KEY,
    properties json
);

CREATE TABLE edges (
edge_id integer PRIMARY KEY,
tail_vertex integer REFERENCES vertices (vertex_id),
head_vertex integer REFERENCES vertices (vertex_id),
label text,
properties json
);

CREATE INDEX edges_tails ON edges (tail_vertex);
CREATE INDEX edges_heads ON edges (head_vertex);
```
Some important aspects of this model are:
* Any vertex can have an edge connecting with any other vertex (even itself). There is no schema restricting any of connections
* Given any vertex, you can efficiently find both its incoming and outgoing edges, and thus _traverse_ the graph
* By using different labels for different kind of relationship, you can store several different kind of information in a single graph, while still maintaining a clean data model.

Graphs are decent for evolvability: as you add features to your app, a graph can easy be extended.

#### Graph queries in SQL
In a relational db, you usually know in advance which joins you need in your query. In a graph query, you may need to traverse number of edges before you find the vertex you're looking for - the number of joins is not fixed in advance.  
Variable-length traversal path in a query can be expressed using something called _recursive common table expression_ (the WITH recursive syntax).  
Just compare the queries from the SQL and Cypher query languages:  
```sh
SQL:
WITH RECURSIVE 
-- in_usa is the set of vertex IDs all locations within USA
in_usa(vertex_id) AS (
    SELECT vertex_id FROM verticies WHERE properties >> 'name' = 'United States'
    UNION
    SELECT edges.tail_vertex FROM edges
        JOIN in_usa ON edges.head_vertex = in_usa.vertex_id
        WHERE edges.label = 'within'
),

-- in_europe is the set of vertex IDs all locations within EU
in_europe(vertex_id) AS (
    SELECT vertex_id FROM verticies WHERE properties >> 'name' = 'Europe'
    UNION
    SELECT edges.tail_vertex FROM edges
        JOIN in_europe ON edges.head_vertex = in_europe.vertex_id
        WHERE edges.label = 'within'
),

born_in_usa(vertex_id) AS (
    SELECT edges.tail_vertex FROM edges
        JOIN in_usa ON edges.head_vertex = in_usa.vertex_id
        WHERE edges.label = 'born_in'
),

lives_in_europe(vertex_id) AS (
    SELECT edges.tail_vertex FROM edges
        JOIN in_europe ON edges.head_vertex = in_europe.vertex_id
        WHERE edges.label = "lives_in"
),

SELECT vertices.properties ->> 'name'
FROM verticies
-- join to find those people who were both born in the US *and* live in EU
JOIN born_in_usa ON verticies.vertex_id = born_in_ua.vertex_id
JOIN lives_in_europe ON verticies.vertex_Id = lives_in_europe.vertex_id;
```
```sh
Cypher:
MATCH
    (person) -[:BORN_IN]-> () -[:WITHIN*0..]-> (us:Location {name:'United States'}),
    (person) -[:LIVES_IN]-> () -[:WITHIN*0..]-> (us:Location {name:'Europe'})
RETURN person.name
```
If the same query can be written in 4 lines in one query language but requires 29 lines in another, that just shows that different data models are designed to satisfy different use cases.
*NOTE*: There is also a triple store model which is very similar to the graph mode.  
The idea behind this model is that all info is stored in a form of very simple three-part statements:  
_(subject, predicate, object)_  

#### Summary
Data models itself is huge subject.  
Historically, data started out being represented as one big tree (the hierarchical model), but this wasn't good for representing many-to-many relationships, so the relational model was invented to solve the problem.  
More recently, developers found that some apps don't fit well the relational model either. New nonrelational 'NoSql' datastores have diverged in two main directories:
* Document dbs target use cases where data comes in self-contained documents and relationship between one document and another is rare
* Graph dbs go in the opposite direction, tartgeting use cases where anything is potentially related to everything

All three models (relational, document, graph) are widely used today, and each is good in its respective domain.
## Storage and retrieval
On the most fundamental level db have to do two things: when you give it some data, it should store the data, and when you ask it again later, it should give the data back to you.  
Why should you, as an app dev, care how the db handles storage and retrieval internally? Yo're probably not gonna implement your own storage engine from scratch (at least yet), but you do need to select a storage engine that is appropriate for your app. In order to tune a storage engine to perform well on your kind of workload, you need to have a rough idea of what the storage engine is doing under the hood.  
In particular, there is a big diff between storage engines that are optimized for transaction workloads and those that are optimized for analytics.  
We will examine two families of storage engines, _log-structured_ storage engines, and _page-oriented_ storage engines such as B-trees.
### Data structures that power your database
Consider the worlds simplest database, implemented as two Bash functions:
```sh
#!/bin/bash  
db_set() {
    echo "$1,$2" >> database
}

db_get() {
    grep "^$1," database | sed -e "s/^$1,//" | tail  -n 1
}
```
This two functions implement key-value store.  
In case you insert two similar keys the last inserted key will be shown (hence the tail -n 1 in db_get()). Example:
```sh
db_set 42 '{"name": "Lviv", "attractions": "Horse"}' (by the way value is a string type so you basically can insert any string there, eg. JSON)
db_set 42 '{"name": "Lviv", "attractions": "Opera House"}'

db_get 42
{"name": "Lviv", "attractions": "Opera House"}
```
The underlying storage format is very simple: a text file where each line contains a key-value pair, separated by a comma.  
Our db_set() func actually has pretty good performance for something that is so simple, because appending to a file is generally very efficient. Simply to what db_set() does, many dbs internally use a _log_, which is append-only data file. Real dbs have more issues to deal with (such as concurrency control, reclaiming disk space so that the log does'nt grow forever, and handling errors and partially written records), but the basic principle is the same. 
!NOTE: The word _log_ is often used to refer to app logs, where an app outputs text that describes what's happening. In this book, _log_ is used in more general sense: an append-only sequence of records. It doesn't have to be human -readable; it might be binary and intended only for other programs to read.  

On the other hand, our db_get() function has terrible performance if you have a large number of records in db. The cost of lookup is O(n).  
In order to efficiently find the value for a parcicular key in the db, we need a different data structure: an index.  
An _index_ is an additional structure that is derived from the primary data.
### Hash indexes
```sh
docker run -d -p 8000:8080 --restart=always --cap-add=SYS_ADMIN --name=test <youruser>/dillinger:${package.json.version}
```
