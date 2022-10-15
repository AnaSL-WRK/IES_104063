# 2.3 Introduction to web apps with a full-featured framework (Spring Boot)

[Spring Boot](https://spring.io/projects/spring-boot) is a rapid application development platform built on top of the popular [Spring Framework](https://spring.io).
By assuming opinionated choices by default (e.g.: assumes common configuration options without the
need to specify everything), Spring Boot is a convention-over-configuration addition to the Spring
platform, useful to get started with minimum effort and create stand-alone, production-grade
applications.

<br>

## Using the Spring Initializr

Spring Initializr templates contain a collection of all
the relevant transitive dependencies that are needed to start a particular functionality and will
simplify the setup of the POM.

You can use this from the website [Spring Initializr](https://start.spring.io) and download the zip, or using the extension <ins>Spring Initializr Java Support</ins> for your IDE (in my case VSCode supports it).

Be sure to add the "Spring Web" and "Thymeleaf starter" dependencies as we are going to need them later.

Here you can now test building your application using ```mvnw spring-boot:run``` and access it from your browser at http://localhost:8080/ , were you should retrieve a page produced by Sping Boot (a white label error)

> if the port 8080 is already at use (like from tomcat on the previous lab) you can change it by going to the application.properties file inside src/main/resources and inserting <code>server.port=8090</code> (per example).

A useful tutorial on basics that are not entirely covered in this lab is [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/), but we will follow a different one later on

<br>

## Building a simple application (Serving Web Content with Spring MVC)

Tutorial we will be using: [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/).

Here you just need to follow the guide and copy the code sniplets

> Make sure to not alter the arlready created Application.java for your web application,as this is a class automatically created by springBoot to run your code.


With all the coding done, you can run ```mvnw spring-boot:run``` again and check it at now http://localhost:8090/ or http://localhost:8090?name=dude.

Be sure to check the [Errors encountered](#errors-encountered) tab to see how I fixed a looping error.

<br>

## Extending our project (Building a RESTful Web Service)

Here you can use the code from the previous exercise as its "roots" are the same. We are extending it to create a REST endpoint, which listen to the HTTP request, and answer witha JSON result (a greeting message)

Tutorial to follow: [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)

After adapting the code you can access it using the [curl utility](https://www.baeldung.com/curl-rest) like

```
curl -o out.json http://localhost:8091/greeting/user=ana
```
 
> with the option ``` -o out.json ``` the output json will be exported to your project folder

> be sure to change the port used if you build another project

<br>

## Errors Encountered

<code>
Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Circular view path [greeting]: would dispatch back to the current handler URL [/greeting] again. Check your ViewResolver setup!
</code>

<br> 

- **Solution**: removing the versions from some POM dependencies:

```xml
        <dependency>
        <groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
```