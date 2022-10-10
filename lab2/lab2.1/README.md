# 2.1 Server-side programming with servlets


## Why use Servlets

A Servlet is a Java programming language class that is used to extend the capabilities of servers that host applications accessed by means of a request-response programming model. Although servlets can respond to any type of request, they are commonly used to extend the applications hosted by web servers.  
The advantages of Servlets are as follows:

**Better performance**: because it creates a thread for each request, not process.  
**Portability:** because it uses Java language.  
**Robust:** JVM manages Servlets, so we don't need to worry about the memory leak, garbage collection, etc.  
**Secure:** because it uses java language.

## Preparing a Tomcat server

For this project we are going to use Apache Tomcat to deploy our servlets.

Download a Tomcat version (we are using 9.0.68, which you can download from [here](https://tomcat.apache.org/download-90.cgi))

Run the server by starting the file startup.bat from the bin folder

To confirm that the Tomcat server is running, you can use:
-  Curl tool:  ``` $curl -I 127.0.0.1:8080```
-  Access the default page in the browser: http://localhost:8080
-  Observe the server log: ```$ tail logs/catalina.out```
-  Observe the last lines of the pop up terminal:  
  ```08-Oct-2022 01:21:37.404 INFO [main] org.apache.coyote.AbstractProtocol.start Starting ProtocolHandler ["http-nio-8080"]```  
```08-Oct-2022 01:21:37.454 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in [1465] milliseconds ```

> be sure to not close the terminal as this will terminate the site

</br>

Here you can investigate the site a bit, but for the next step we are accessing the manager environment.  
To do that we need to register at least one role in conf/tomcat-users.xml.

      <role rolename="manager-gui"/>  
      <role rolename="manager-script"/>  
      <user username="admin" password="secret" roles="manager-gui,manager-script"/>

</br>

Restart the server and access the manager app (http://localhost:8080/manager)

> Here you can see useful code sniplets of request parameters in Examples --> Servlet --> Request Parameters
> And deploy and un-deploy applications you develop


## Creating web application

We are now creating a web application and deploy it into Tomcat.  
This is different from a standard Java application and requires some extra configuration, that can be obtained from a suitable archetype
</br>

Adjust the groupId and arcifactId to your project  

      mvn archetype:generate -DgroupId=ua.ana -DartifactId=webApp -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=webapp-javaee7 -DarchetypeVersion=1.1 -DinteractiveMode=false

Now we can build the project to ensure there are no errors and experiment deploying it to the Tomcat server

    mvn install
    mvn package
    
> I encountered a problem while deploying, please refer to [Errors encountered](#errors-encountered) to see how it's fixed

### Deploy the packed application (.war) into the application server.
Use the Tomcat management interface to upload and deploy the .war file:  deploy --> war file to deploy --> select your file and deploy  
or
copy the .war file into <Tomcat root>/webapps
  
</br>

Now you can access it from http://localhost:8080/webApp-1.0-SNAPSHOT/ (in my case) or from the applications menu in the manager site



## Setting up your IDE for integrated deployment support

Deploying using the Tomcat Manager page has some disadvantages: it is not “connected” with the IDE and is specific to Tomcat.  
The productive alternative is to use the IDE integrated deployment support. 

In my case, VSCode, you need to install <ins>Community Server Connectors</ins> extension by Red Hat.  
You would need to create a new server, by right clicking on the servers subsection now created and reference to the file you just downloaded, or use one automatically downloaded from the internet by the extension.

> I usually do all my work in my University OneDrive, these labs included. In this case it would be impossible to deploy the server from my directory since the path to the Tomcat server in the JSON file would be  
> ```c:\\Users\\anawk\\OneDrive - Universidade de Aveiro\\Uni\\3.ano\\IES\\IES_104063\\lab2\\lab2.1\\apache tomcat 9.0.68```
> which includes the illegal expression "OneDrive **-** Universidade de Aveiro" making it impossible to deploy


I will continue this project using the VSCode extension and integrated download, making it easier and faster to deploy and reload

> by going with the server extension and integrated download, you wont be able to access tha manager page, as tomcat-users.xml wont be editable

If you still need help integrating the servers into VSCode you can follow this [tutorial](https://nyumbani-coder.hashnode.dev/how-to-create-java-servlet-with-tomcat-and-maven-in-vs-code)

## Building the servlet

now you build your servlet under the java.groupID like a normal maven project, package it and then add the .war as depository (either by the manager site or the server extension, by right clicking the .war and 
select run on server)
> since we are using a @WebServlet Annotation, we don't need to create a web.xml file.
  
to access it : http://localhost:8080/webApp-1.0-SNAPSHOT/webServlet (for this project)
  
  </br>
  
> http://localhost:8080/ Name of war file /url pattern defined in .java

</br>

Since for this project we need to pass a parameter for the page to work, adding ?username=name at the end of the url will make it work.
 
  
  
 ## Errors encountered
  
   <code>Failed to execute goal org.apache.maven.plugins:maven-war-plugin:2.6:war (default-war) on project webApp:  
     Execution default-war of goal org.apache.maven.plugins:maven-war-plugin:2.6:war failed: Unable to load the mojo 'war' in the plugin  
     org.apache.maven.plugins:maven-war-plugin:2.6' due to an API incompatibility:  
     org.codehaus.plexus.component.repository.exception.ComponentLookupException: null </code>

  - **Solution**: Changing version from 2.3 to 3.1.0 in 
  
    ```
      <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <failOnMissingWebXml>false</failOnMissingWebXml>
                </configuration>
      </plugin>  
 
  
  <code> Plugin execution not covered by lifecycle configuration </code>
  - **Solution**: in the pom file: add  ```<pluginManagement>``` after the ```<build>``` tag (and close it before)

        
        
        
        
        
