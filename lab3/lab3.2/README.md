# 3.2 Multilayer applications: exposing data with REST interface

For this part of the lab we are going to need an instance of MySQL server. If you don’t have one already, consider using a Docker container.
> If you find a problem with your Docker Desktop please refer to [Errors encountered](#errors-encountered)

To create this instance you just need to paste the following code to your CMD 

```cmd
docker run --name mysql5 -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d mysql/mysqlserver:5.7
```

We are now following this tutorial to make the rest of the project : [Spring Boot 2 JPA MySQL CRUD](https://www.javaguides.net/2018/09/spring-boot-2-jpa-mysql-crud-example.html)


You can start your Spring-boot project using <u>Spring Initializr</u> with the following dependencies:

- Spring Web
- Spring Data JPA
- MySQL driver
- DevTools-
- Validation
  
  <br>

Be sure to define the database connection properties with the application.properties resource
file. E.g:
```
# MySQL
spring.datasource.url=jdbc:mysql://127.0.0.1:33060demo
spring.datasource.username=demo
spring.datasource.password=secret2
spring.jpa.database-platform=org.hibernate.dialectMySQL5InnoDBDialect

# Strategy to auto update the schemas (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update
```
<br>

After following the tutorial and starting your instance of the MySQL server you can now test it at
http://localhost:8080/api/v1/employees

> In order to test all controllers, I used [Postman](https://www.postman.com/downloads/) and I highly recommend you to install it, as it makes it easy to control everything.

<br>

>Updating a user uses the HTTP Method PUT, contrary to what the tutorial says

<br>

### Enhancing the REST API with a method to search an Employee by email

All we need to do is add to our <u>EmployeeRepository</u> an attribute to allow us to search by email, like this:

```java
    Employee findByEmail(String email);
```

and then add the mapping to our <u>EmployeeController</u>

```java
@GetMapping(value ="/employees", params = "email")
	public ResponseEntity<Employee> getEmployeeByEmail(@RequestParam(value = "email") String email) throws ResourceNotFoundException
			{
				Employee employee = employeeRepository.findByEmail(email);
				return ResponseEntity.ok().body(employee);
			}
``` 
<br>

## Errors Encountered 

This isnt a coding error, but a software one.
While trying to open Docker, as we have previously used it, it gave me the error <code>Docker failed to initialize. Docker Desktop is shutting down </code>  
I tried uninstalling it and reinstalling it but the error remained.

<br>

**Solution**: Deleting all docker folders in:

- C:\Users\user\AppData\Local
- C:\Users\user\AppData\Roaming
- C:\Users\user
