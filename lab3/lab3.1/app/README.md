# 3.1 Accessing databases in SpringBoot



The <ins>Jakarta Persistence API</ins> (JPA) defines a standard interface to manage data over relational databases;  
There are several frameworks that implement the JPA specification, such as the Hibernate framework.  
JPA offers a specification for ORM (object-relational mapping).
Spring Data uses and enhances the JPA. When you use Spring Data your Java code is independent from the specific database implementation.

## Spring boot CRUD[^1] application with Thymeleaf

For this part of the lab we are following this tutorial: [Spring Boot CRUD Application](https://www.baeldung.com/spring-boot-crud-thymeleaf)  

[^1]: CRUD = Create, read, update and delete

The dependencies for the tutorial can be automatically imported via <ins>Spring Initializr</ins> (same procedure as last lab) with the following dependencies:
- Spring Web
- Thymeleaf
- Spring Data JPA
- H2 database
- Validation

While following the tutorial I still managed to find some annoying errors, to see them please refer to [Errors encountered](#errors-encountered)


---
## Lab questions (b)

**- The “UserController” class gets an instance of “UserRepository” through its constructor; how is this new repository instantiated?**

In <u>UserController</u> we use the annotation <code>@Autowired</code>, while referencing the <u>UserRepository</u> class.  
The <u>Autowiring</u> feature of spring framework enables you to inject the object dependency implicitly.

<br>
<br>

**- List the methods invoked in the “UserRepository” object by the “UserController”. Where are these methods defined?**

The methods invoked in the <u>CrudRepository</u>, (class extended by <u>UserRepository</u>) are:

- findAll(),
- findById(),
- save(),
- delete().

<br>
<br>

**-Where is the data being saved?**

The data is being saved by the <u> H2 database</u> (added to the project as a dependency, in pom.xml), as it has an in memory database.

<br>
<br>

**-Where is the rule for the “not empty” email address defined?**

The "not empty" rule is defined in the <u>User</u>, with the annotation ```@NotBlank``` when we declare the email attribute.

<br>

## Errors Encountered

- ```the Javax imports weren't loading```



- **Solution**: As I knew they were included in the spring-boot starter data jpa dependency, it couldnt be a code-sided error so even though I tried many commands and restarts to get them to work, I ended up just deleting the project and remaking it the same way. The true engineer way!

<br>

- ```The import org.springframework.stereotype.Repository conflicts with a type defined in the same file```
- **Solution**: It turned out that I named my file <code>Repository.java</code> which conflicted with the annotation <code>Controller</code>

<br>

- ```Error executing DDL "drop table if exists user cascade" via JDBC Statement```
- **Solution**: ```user``` is a reserved word in PostgreSQL, make sure you name the <u>User</u> entity as <u>users</u> or any other name using ```@Entity(name="users")``` on the file <u>User.java</u>

