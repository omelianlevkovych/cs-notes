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

# Google Cloud Computing Services
Most of the services can be grouped into several core categories:
* Computing resources
* Storage resources
* Dbs
* Network services
* Identity management and security
* Development/management tools
* Specialized services
A Google-certified Associate Cloud Engineer should be familiar with the services in each category, how they are used,
and the advantages and disadvantages of the various services in each category.  
## Computing resources
At one end of the spectrum, customers can create and manage VMs themself. This type of computing service is typically referred
to as infrastructure as a service (IaaS).
An alternative model is called platform as a service (PaaS), which provides a runtime environment to execute applications without
the need to manage underlying servers, networks, and storage systems.  
GCP IaaS - Compute Engine.  
GCP PaaS - App Engine, Cloud Functions.  
Google also offers a k8s engine, which is a service for managing containers in a cluster.  
### Compute Engine
VMs. GCP uses a security hardened version of the KVM hypervisor. KVM stands for Kernel Virtual Machine and provides virtualization
on Linux systems running on x86 hardware.  
### Kubernetes Engine
### App Engine
Deploy app to the serverless app env.  
App engine is available in two types: standard and flexible.  
The standard env is good for the one of supported languages (source code) and when you do not need OS packages or other compiled
software that would have to be installed along with the app code.  
In the flexible env you run the Docker containers in the App Engine env.  
The flexible env works well when you have app code but also need libraries or other third-party software installed.  
The flexible env gives you more options like the ability to work with the background processes and write to local disk.  
## Cloud Functions
Event-driven approach.
# Storage Components of Google Cloud Platform
## Cloud Storage
Cloud storage is GCP object storage. Objects can be any type of file or binary large object.  
Objects are organized into buckets, analogous to directories in a file system.  
It is important to rememer that Cloud Storage _is not a file system_. It is a service that receives, stores and retrieves files
or objects from a distributed storage system.  
Each storage object is uniquely accessible by a URL.  
Cloud Storage is useful for storing objects that are treated as single unit of data. For example, an image file is a good
candidate for object storage. Images are generally read and written _all at once_. There is rarely need to retrieve only a portion
of the image.  
In addition to high availability and durability, multiregions storage allows for faster access to data when users or apps are
distributed across regions.  
The _cold storage class_ is a low cost archival storage designed for high durability and infrequent access. This class of storage
is suitable for data that is accessed less than once per year.
Test commit.