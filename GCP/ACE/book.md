# Overview of GCP
Public cloud providers offers services that fall into four broad categories:
* Compute resources
* Storage
* Networking
* Specialized services such as Machine Learning Services

## Compute resources
- Virtual machines
VM are a basic unit of computing resources.  
A VM that u manage is like having a server in your office that you have full admin rights.  
- Managed K8s clusters
- Serverless computing
GCP has two serverless computing options:
* AppEngine
Used for apps and containers that run for extended period of time, such as website backend, point-of-sale system,
or custom business apps.
* CloudFunction
Cloud function is a platform for running code in response to an event.  
## Storage
- object storage (blob)
Usually objects are files, but the files are not stored in a conventional file system. Objects are grouped into buckets.
Each object is individually addressable, usually by a URL.  
Object storage is not limited by the size of disk. Objects can be uploaded without concern for the amount of space available
on a disk. Multiple copies of objects are stored to improve availability and durability. 
- file storage
Provide a hierarchical storage system for files. File systems storage provides network shared file systems. GCP has a file storage
service called Cloud Filestore, which is based on NFS storage system. It is suitable for the apps that require operating system-like
file access to files. The file system, its directories, and its files exist independent of VMs or apps that may access these files.
- block storage
You can install file system on top of the block storage or run apps that access block directly. In linux file systems, 4kb is a common
block size. Relational dbs ofter write directly to blocks, but they often use larger sizes, such as 8kb or more.
Object storage does not support operating system- or file system-level access; you have to use higher-level protocols like HTTP to access
objects. It takes longer to retrieve data from object storage than to retrieve it from block storage.
- caches

## Networking
Each network accessible device or service in your env will need an IP address. In fact, devices within GCP can have both internal
and external addresses. Internal addresses are only accessible only to services in your internal GCP network.
Your internal GCP network is defined as a virutal private cloud (VPC).  
External are accessible from the Internet. External IPs can be static or ephemeral. Static addresses are assigned to a device
for extended period of time. Ephemeral external IP addresses are attached to VMs and released when the VM is stopped.  
In addition to IPs, you will often need to define firewall rules to control access to subnetworks and VMs in your VPC.

