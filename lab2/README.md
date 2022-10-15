# Lab 2 - Java at the server-side and the role of application containers

Ana Loureiro, n104063, [LEI]

## Learning outcomes

- Deploy a java web application into an application container (servlets).
- Start a simple web application with Spring Boot and Spring Initializr.

<br>

This folder <ins>Lab2</ins> is composed by a subfolder for each of the labs section, each one including its own README file about its topic:

- [Lab 2.1](/lab2/lab2.1): Server-side programming with servlets
- [Lab 2.2](/lab2/lab2.2): Server-side programming with embedded servers
- [Lab 2.3](/lab2/lab2.3): Introduction to web apps with a full-featured framework (Spring Boot)

- [Lab 2.4](/lab2/lab2.4): (Wrapping-up & integrating concepts) doens't have a README file as it implements previous concepts.

<br>

## Review questions

**A) What are the responsibilities/services of a “servlet container”?**

A servlet container uses java to dinamically generate a web page on the server side (essencially a part of a web server that interacts with servlets).  
It is responsible for accepting a request, process it and send it back and they are capable of performing many operations like: 

- Life Cycle Management
- Multithreaded support
- Object Pooling
- Security

___

**B) Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content.**

The **Spring Web model-view-controller (MVC)** framework is designed around a ```DispatcherServlet``` that dispatches requests to handlers, with configurable handler mappings, view resolution, locale and theme resolution as well as support for uploading files. The default handler is based on the ```@Controller``` and ```@RequestMapping``` annotations, offering a wide range of flexible handling methods. With the introduction of Spring 3.0, the ```@Controller``` mechanism also allows you to create <ins>RESTful Web sites</ins> and applications, through the ```@PathVariable``` annotation and other features.
___

**C) Inspect the POM.xml for the previous Spring Boot projects. What is the role of the “starters” dependencies?**

The starter dependencies allow us to add jars in the classpath. Other "starter dependencies" simply provide dependencies that we are likely to need when developing a specific type of application. Since we were developing a web application in [Lab 2.3](/lab2/lab2.3), we added the "Spring Web" dependency in the creation of the project.

Spring Boot starters makes it easier and faster to start developing a project

___

**D) Which annotations are transitively included in the @SpringBootApplication?**

A single ```@SpringBootApplication``` annotation can be used to enable three features that help with autocofigure:

- ```@EnableAutoConfiguration```: enables Spring Boot’s auto-configuration mechanism
- ```@ComponentScan```: enables ```@Component``` scan on the package where the application is located
- ```@Configuration```: allows to register extra beans in the context or import additional configuration classes

The ```@SpringBootApplication``` annotation is equivalent to using ```@Configuration```, ```@EnableAutoConfiguration```, and ```@ComponentScan``` with their default attributes

___

**E) Search online for the topic “Best practices for REST API design”. From what you could learn, select your “top 5” practices and briefly explain them in you own words.**

- **Handle errors gracefully and return standard error codes**: You should try to handle errors returning (per example) HTTP Status code (like 400, 404, 500) to indicate to the API user what kind of error occured (so they can also understand if it was on their side or the server side) and also to help give the API maintainers enough information to know what happened and what to fix.

- **Cache data to improve performance**: Using cache you can return data from the local memory cache instead of querying the database to get the data everytime a user requests something, allowing them to retrieve the data faster.

- **Versioning our APIs**: We should reserve different versions of the API when making changes as some may break third party apps that use the API.

- **Use nouns instead of verbs in endpoint paths**: We should use nouns that represent the entity that the endpoint that we're retrieving or manipulating, as their pathname. The most commong methods name are GET, POST, PUT and DELETE which are quite descriptive of what they do.

- **Maintain good security practices**: Most communications between server and client should be private since an API often sends and recieves private information. So using SSL/TLS for security should be a must since the certificate isn't dificult to load onto a server and the cost is either free or very low.
