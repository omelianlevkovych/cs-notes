# basics
Simply, when your API publishes even messages, it doesn't directly send them.  
Instead, the messages are **persisted** in a database table.  
After that, a job publish events to message broker.  

Basically, the Outbox pattern provides to publish events **reliably**.  
The idea of this approach is to have an 'Outbox' table in the microservices db.  

* In the Outbox pattern, we use the ACID properites of an RDBMS. We write not only to the table that stores the entity that we are inserting, updating, or deleting, but also we write the message we intend to send to an ‘outbox table’ in the same Db.
* We mark the time that the message was written, as part of the transaction, on the record.
* Then when we send the message via the Broker, we mark the message as dispatched in the table.

# and what about consumer?
Outbox pattern offers us guaranteed, at least once delivery. Consumers must be prepared for this. Either they can use an Inbox, which records all the messages they have seen recently and discards duplicates, or they must be idempotent and the result of processing the message twice has no side-affects.

# when to use it?
If you are working with critical data and you care about consistency a lot.  


# Q/A
- Oh okay, so the problem here is the following. You can try to handle entity update and publishing
to some message broker as one transaction, but think about implementation details. How are you going
to rollback that published message? There are ideas, but probably Outbox approach is simpler.
- Lol, just the next sentance from the doc here (https://paramore.readthedocs.io/en/latest/OutboxPattern.html#)
tells why probably other solutions are not optimal (like two-phase-commits or any other distributed transactions):  
Distributed Transactions may seem like an answer, but possess two issues. First, we are probably using a backing store and message-oriented middleware from different vendors or OSS projects that don’t support the same distributed transaction protocol. Second, distributed transactions don’t scale well.  
