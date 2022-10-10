# 2.2 Server-side programming with embedded servers
For some use cases, you may prefer to run the web container from within your app.  
In this case, we
will be using an “embedded server”, since its lifecycle (start, stop) and the deployment of the artifacts is controlled by the application code.

For this sub-lab we are adapting [Lab2.1's code](https://github.com/AnaSL-WRK/IES_104063/tree/main/lab2/lab2.1/webApp) to perform on an embedded server instead of Apache Tomcat.

## Embedded server using the Jetty server

Useful tutorial: [Embedded server example using the Jetty server](https://examples.javacodegeeks.com/enterprise-java/jetty/embedded-jetty-server-example/)

Having finished lab2.1, this lab is easy to adapt and fast to execute.

First we create the Maven project from the quickstart archetype.


Add these dependencies to the pom.xml file for the jetty server to work:

```xml
<dependency>
      <groupId>org.eclipse.jetty</groupId>
      <artifactId>jetty-server</artifactId>
      <version>9.4.48.v20220622</version>
  </dependency>
  <dependency>
      <groupId>org.eclipse.jetty</groupId>
      <artifactId>jetty-servlet</artifactId>
      <version>9.4.48.v20220622</version>
  </dependency>
```

> In the tutorial above they use version 9.2.15.v20160210 for both dependencies which were found to have vulnerabilities. Browsing through versions I found that these work the best without any compromise.  
> 
> If you want to check the versions yourself browse through these links:  
> - [jetty-server](https://mvnrepository.com/artifact/org.eclipse.jetty/jetty-server)
> - [jetty-servlet](https://mvnrepository.com/artifact/org.eclipse.jetty/jetty-servlet)

</br>


Important imports to have on your java file (other than the ones you need for your servlet):

```java
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
```

From here all you need to do is create the server and handle it with this code: 

```java
 public static void main(String[] args) throws Exception {
         
    Server server = new Server(8680);       
     
    ServletHandler servletHandler = new ServletHandler();
    server.setHandler(servletHandler);
             
    servletHandler.addServletWithMapping(JettyServlet.class, "/");
     
    server.start();
    server.join();
    }
```

Which will host your server on port 8680 (access it from http://localhost:8680)

To include your servlet in the file, you can create the class under this code and reference it on the <code>servletHandler.addServletWithMapping(JettyServlet.class, "/");</code>

All theres left to do is run your java file and access it from the web!
