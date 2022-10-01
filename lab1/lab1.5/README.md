# 1.5 Wrapping-up & integrating concepts

In this lab we were meant to separate our project "MyWeatherRadar" into two separate Maven projects:
- IpmaApiClient that deals with the API communication (API folder)
- WeatherForecastByCity that deals with the client communication and its only dependency is the project IpmaApiClient (CLIENT folder)

<br>

To create this dependency we had to insert this code into the CLIENT's Pom file:

```
  <dependency>
      <groupId>ua.ies.ana</groupId>
      <artifactId>ipma_api_client</artifactId>
      <version>1.0-SNAPSHOT</version>
  </dependency>
  ```
  
  <br>
  
  After this integration the rest of the project consisted on the java code adaptations for both files
  
  <br>
  
  To run, we had first to ```mvn package``` our API project, since we are going to need the .jar file for our client's side dependency to work  
  Then, package our CLIENT project and run!
  
  ```mvn exec:java -Dexec.mainClass="ua.ies.ana.WeatherForecastByCity" -Dexec.args="Porto Aveiro Lisboa"```
  
  > Sometimes dependencies wouldn't load so I used  ```mvn dependency:list``` or  ```mvn clean install``` and then repackage the projects

  
