# ToDo
- Create a Compute Engine VM using the gcp console.
- Create a Compute Engine VM using the gcloud cli.
- Connect between the two instances.

# Task1
## *Create VM using gcp console*
1) Nav menu > compute engine > VM instances
2) Boot disk - Debian GNU/Linux 10 (Buster)
3) For Firewall, allow http traffic

# Task2
## *Create VM using gcloud CLI*
1) Open Cloud Shell
2) Display a list of all the zones in the region:
```sh
$ gcloud compute zones list | grep [region]
```
3) Set the default zone:
```sh
$ gcloud config set compute/zone [zone]
```
4) Create a VM instance called _my-vm-2_:
```sh
$ gcloud compute instances create "my-vm-2" \
--machine-type "n1-standard-1" \
--image-project "debian-cloud" \
--image-family "debian-10" \
--subnet default
```

# Task3
## *Connect between VM instances*
Notice that the Internal IP addresses of these two instances share the first three bytes in common.  
They reside the same subnet in their GC VPC even though they are in different zones.  
1) Open SSH for my-vm-2.:
2) Use ping to confirm that my-vm-2 can reach my-vm-1 over the network.  
```sh
$ ping my-vm-1.us-central1-a
```
Notice that the output of the ping command reveals that the complete hostname of my-vm-1 is my-vm-1.us-central1-a.c.PROJECT_ID.internal, where PROJECT_ID is the name of your Google Cloud Platform project.  
GCP automatically supplies Domain Name Service (DNS) resolution for the internal IP addresses of VM instances.
3) Use SSH to open cli for my-vm-1:
```sh
$ ssh my-vm-1.us-central1-a
```
4) Install Nginx web server on vm1:
```sh
$ sudo apt-get install nginx-light -y
```
5) Use the nano text editor to add a custom message:
```sh
$ sudo nano /var/www/html/index.nginx-debian.html
```
6) Confirm that a web server actually serving your page:
```sh
$ curl http://localhost/ (http://127.0.0.1/)
```
7) Exit the remove ssh vm1 and get back to vm2, now try to connect to the vm1 web server page:
```sh
$ curl http://my-vm-1.us-central1-a/
```