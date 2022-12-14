# Lab 3 Multi-layer web applications with Spring Boot

Ana Loureiro, n104063, [LEI]

## Learning outcomes

- Develop web projects with Spring Boot. Create and persist entities into a relational database using Spring Data.
⎯ Deploy Spring Boot application in Docker.

<br>

This folder <ins>Lab3</ins> is composed by subfolders for each of the lab's section, each one including its own README file about its topic:

- [Lab 3.1](/lab3/lab3.1): Accessing databases in SpringBoot
- [Lab 3.2](/lab3/lab3.2): Multilayer applications: exposing data with REST interface 
- [Lab 3.3](/lab3/lab3.3): (Wrapping-up & integrating concepts) doens't have a README file as it implements previous concepts.

<br> 


## Review questions

**A) Explain the differences between the RestController and Controller components used in different parts of this lab.**

The ```@Controller``` annotation is a specialization of the <ins>```@Component```</ins> class, which allows us to auto-detect implementation classes through the classpath scanning.
We typically use ```@Controller``` in combination with ```@RequestMapping```  for request handling methods.  
You annotate the request handling method with ```@ResponseBody```, enabling automatic serialization of the return object into the HttpResponse.  
<br>

The ```@RestController``` is a specialized version of the controller. It includes the ```@Controller``` and ```@ResponseBody``` annotations, and as a result, simplifies the controller implementation.
You use it with ```@RestController```; therefore, the ```@ResponseBody``` isn't required. (Every request handling method of the controller class automatically serializes return objects into HttpResponse.)
___

**B)Create a visualization of the Spring Boot layers (UML diagram or similar), displaying the key abstractions in the solution of 3.3, in particular: entities, repositories, services and REST controllers. Describe the role of the elements modeled in the diagram.**
See: [Lab 3.3 / UML.png](/lab3/UML.png)

- <ins>Domain Objects</ins>: Objects that represent the data in the application and what we manipulate throughout the code, hence being **connected to all elements** (except the database, directly).

- <ins>@RestController</ins>: As explained in the previous question, it takes care of mapping request data (hence being **connected to <ins>Domain Objects</ins>**) to the defined request handler method (and so, **being connected to <ins>@Service</ins>**).

- <ins>@Service</ins>: Holds all the business logic that is requested by the <ins>@RestController</ins> using the <ins>Domain Objects</ins> (having a **bidirectional connection with the Objects**) and using the information from the <ins>@Repository</ins>, via <ins>@AutoWired</ins> (having a **unidirectional connection with it**).

- <ins>@Repository</ins>: Provides the mechanism for storage, retrieval, search, update and delete operation on objects from the <ins>Database</ins> (hence the**bidirectional connection**). These mechanisms are used in <ins>@Service</ins>, and are done by manipulating the <ins>Domain Objects</ins> with these methods (hence having a **unidirectional connection with them**)

- <ins>Database</ins>: Made up of a collection of tables, storing all the structured data manipulated throughout the application. It's information is manipulated by the <ins>@Repository</ins>, hence the **bidirectional connection to it**.

___

**C) Explain the annotations @Table, @Colum, @Id found in the Employee entity.**

- ```@Table```: It specifies the table in the database with which its entity is mapped. In [Lab 3.2 / Employee.java](/lab3/lab3.2/employeemanage/src/main/java/ua/ana/employeemanage/Employee.java), the data will be stored in the <ins>“employees”</ins> table. The <ins>name</ins> attribute of the this annotation is used to specify the table name.

- ```@Column```: Specifies the column mapping using ```@Column``` annotation, which "appends" to our ```@Table```. The <ins>name</ins> attribute of this annotation is used for specifying the table’s column name.

- ```@Id```: This annotation specifies the primary key of the entity. In the <ins>Employee</ins> application, the ```@Id``` was connected to the ```@GeneratedValue``` <ins>id</ins>.
  
___

**D) Explain the use of the annotation @AutoWired (in the Rest Controller class)**

The ```@Autowired``` allows Spring to resolve and inject collaborating beans into our bean. We can use autowiring on properties, setters and constructors.
[Lab 3.3 / MovieController.java](/lab3/lab3.3/quotesapi/src/main/java/ua/ana/quotesapi/controllers/MovieController.java) we use it to inject our Service class to our Controller.  

