# Associate Cloud Engineer
## Other courses to take in advance
* Google Cloud Fundamentals: Core Infrastructure
* Architecting with Google Cloud Engine
* Getting started with Google Kubernetes Engine

by itself the Architecting with GCE:
* Essential Cloud Infrastructure: Foundation
* Essential Cloud Infrastructure: Core Services
* Elastic Cloud Infrastructure: Scailing and Automation

Find out what you know and make note of what you don't...  
Be as specific as possible to make your study time more productive.  


The exam will test your knowleadge of the following:
* Planning a cloud solution using one or more GCP services
* Creating a cloud environment for the organization
* Deploying applications and infrastructure
* Using monitoring and logging to ensure availability of cloud solutions
* Setting up identity management, access controls, and other security measures
(the more specific info is in the book as well as a test example)  



Projects are the main way you orginize resource in the GCP.  
User should only have those privilidges, and NOT more, that are needed to do their job.  
In the least priviledge envorinment people are protected from the entire class of errors.  

Resource hierarchy:  
Levels of the hierarchy provide trust boundaries and resource isolation.  
resource > projects > folders > org node


Each project has three identifying attributes:
* ProjectId, globally unique, chosen by you, immutable
* ProjectName, need to be unique, chosen by you, mutable
* ProjectNumber, globally unique, assigned by GCP, immutable

Policies implemented at a higher level in the hierarchy can’t take away access that’s granted at lower level.
For example, suppose that a policy applied on a project gives user Jane the right to modify a Cloud Storage bucket.
But a policy at the organization level says that she can only view Cloud Storage buckets, not change them.
The more generous policy is the one that takes effect. Jane can modify the bucket.


GCP Identity and Access Management defines:
* Who
* can do what
* on which resource

There are three types of IAM roles:
* primitive, apply across all GCP services in the project (on all resources): Owner, Editor, Viewer
* predefined, apply to a particualr GCP service in the proj (on ComputeEngine resources in the proj, or folder, or org)
* custom, can be used on proj or org level, not the folder level

Service Accounts control server-to-server interactions (M2M)

There are four ways to interact with GCP:
* Cloud Platform Console
* Cloud Shell and Cloud SDK. Includes command-line tools for Cloud Platform products and services: gcloud, gsutil (cloud storage), bq (big query)
* Cloud Console Mobile App
* Rest-based API. Most APIs include daily quotas and rates (limits) that can be raised by request.

Use API Explorer to help you write the code:
* The Api Explorer is an interactive tool that lets you easily try Google APIs using browser
* With the API Explorer you can:
 * Browse quickly through available APIs and versions
 * See methods available for each API and params they support
 * Execute requests for any method and see response in real time
 * Easily make auth calls

Use client libraries to control GCP resources from within your code.

# Cloud Marketplace (Cloud Launcher)


