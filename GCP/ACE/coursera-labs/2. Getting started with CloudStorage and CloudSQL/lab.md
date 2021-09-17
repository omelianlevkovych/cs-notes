# ToDo
- Create a Cloud Storage bucket and place an image into it.
- Create a Cloud SQL isntance and config it.
- Connect to the Cloud SQL instance from the web server (apache2).
- Use the image in the Cloud Storage bucket on a web page.

# Task1
## *Deploy a web server VM instance*
1) Create VM instance (firewall: allow http)
2) Setup a startup script:
```sh
apt-get update
apt-get install apache2 php php-mysql -y
service apache2 restart
```

# Task2
## *Create a Cloud Storage bucket using the gsutil command line*
1) For the convinience, enter your chosen location into ENVVARIABLE called LOCATION
```sh
export LOCATION=EU
```
2) In Cloud Shell, the DEVSHELL_PROJECT_ID environment variable contains your project ID.  
Enter the command to make named after your proj-id:
```sh
gsutil mb -l $LOCATION gs://$DEVSHELL_PROJECT_ID
```
3) Get the image from the publicly accessible Cloud Storage location:
```sh
gsutil cp gs://cloud-training/gcpfci/my-excellent-blog.png my-excellent-blog.png
```
4) Copy to your Cloud Storage bucket:
```sh
gsutil cp my-excellent-blog.png gs://$DEVSHELL_PROJECT_ID/my-excellent-blog.png
```
5) Modify access so it can be accessible from everywhere:
```sh
gsutil acl ch -u allUsers:R gs://$DEVSHELL_PROJECT_ID/my-excellent-blog.png
```
# Task3
## *Create the Cloud SQL instance*
1) Create instance via the GCP Console (UI).
2) Add user account.
3) In connection tab, add network:
```sh
35.192.208.2/32 // the IP can very
```
# Task4
## *Configure an application in a Compute Engine instance to use Cloud SQL*
1) SHH VM.
2) Change your working directory to the document root of the web server:
```sh
cd /var/www/html
```
3) Use nano to modify page:
```sh
sudo nano index.php
```
4) Paste content:
```sh
<html>
<head><title>Welcome to my excellent blog</title></head>
<body>
<h1>Welcome to my excellent blog</h1>
<?php
 $dbserver = "CLOUDSQLIP";
$dbuser = "blogdbuser";
$dbpassword = "DBPASSWORD";
// In a production blog, we would not store the MySQL
// password in the document root. Instead, we would store it in a
// configuration file elsewhere on the web server VM instance.
$conn = new mysqli($dbserver, $dbuser, $dbpassword);
if (mysqli_connect_error()) {
        echo ("Database connection failed: " . mysqli_connect_error());
} else {
        echo ("Database connection succeeded.");
}
?>
</body></html>
```
5) Restart the web server:
```sh
sudo service apache2 restart
```
# Task5
## *Configure an application in a Compute Engine instance to use a Cloud Storage object*
1) SSH VM.
2) 
```sh
cd /var/www/html
```
3) Paste image source:
```sh
<img src='https://storage.googleapis.com/qwiklabs-gcp-0005e186fa559a09/my-excellent-blog.png'>
```
4) Restart apache2, open the page, congrats!