Lab 1.2: Build management with the Maven tool

Ana Loureiro, 104063, UA


Why use Maven? 

Maven is used for building and managing any Java-based project, making the day-to-day work of Java developers easier and generally help with the comprehension of any Java-based project. It makes projects easy to build, consistent, has a dependency management including automatic updating and quality project information (log document, cross referenced sources, dependency list, unit test reports etc.)

Setting up Maven

Make sure to have Java installed in your environment:
Check by using "$ javac -version" or download from https://www.oracle.com/java/technologies/downloads/

Install Maven by downloading and following this tutorial: https://maven.apache.org/install.html  (be sure have JAVA_HOME added to your PATH, as explained on the site)


Creating a project

Helpful tutorial: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

From Command Line:

> Note that we will be creating a project using a Maven archetype¹

"mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false"

You should change the groupId² and artifactId³ to fit your project. Be sure to follow the naming conventions for these properties 
https://maven.apache.org/guides/mini/guide-naming-conventions.html


From IDE (VsCode, in my case):

>Make sure to install the Java and Maven Extensions on your IDE

Right click on yuor file explorer toolbar and select "Create Maven Project"
Select "maven-archetype-quickstart", giving us the same template as the CLI
Enter the Version (1.0 SNAPSHOT is default but you can select the most recent one), groupId and artifactId and the folder it will be created on.


Using Maven - weather forecast project

For this project we are creating a Java application to invoke the weather forecast API available from IPMA.

-> Create a New Maven Project named MyWeatherRadar (change the name property on the pom⁴ file, not to confuse with artifactId)
-> Change some of the Content of the pom.xml


Template for developer info:

 <developers>
        <developer>
            <id>ana</id>
            <name>Ana Loureiro</name>
            <email>ana.sl@ua.pt</email>
            <url>https://github.com/AnaSL-WRK/</url>
            <organization>UA</organization>
            <organizationUrl>https://www.ua.pt</organizationUrl>
            <roles>
                <role>developer</role>
            </roles>
            <timezone>GMT+1</timezone>
        </developer>
    </developers>


Useful properties to include (character encoding and Java version used):

<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
  </properties>


Dependencies used for this project (Retrofit⁵ and Gson⁶):

<dependency>
	    <groupId>com.squareup.retrofit2</groupId>
	    <artifactId>retrofit</artifactId>
	    <version>2.9.0</version>
</dependency>  

<dependency>  
      <groupId>com.squareup.retrofit2</groupId>
      <artifactId>converter-gson</artifactId>
      <version>2.3.0</version>
</dependency>


Check the latest version of:
Retrofit: https://search.maven.org/search?q=g:com.squareup.retrofit2%20AND%20a:retrofit
Gson: https://search.maven.org/search?q=g:com.squareup.retrofit2%20AND%20a:converter-gson

> Maven automatically retrieves the dependencies from Maven Central Repository (https://search.maven.org)


For the project itself we used base implementations already available, but take note that:

-> all of the files have to be inside the directory created with your groupId (src\main\java\ua\ana in my case)
-> when using outside implementations, you need to change the name of the package imported  (package ua.ana)
-> make sure the name of the class is the same as the name of the file (case sensitive)


When the project is done you can compile and run, either from the IDE or the CLI, by using:

$ mvn package       (gets dependencies, compiles the project and creates the jar file)

$ mvn exec:java -Dexec.mainClass="ua.ana.WeatherStarter"  (mainClass="groupId.class Name of your 'main file')


In case you want to pass arguments you can use:

$ mvn exec:java -Dexec.mainClass="ua.ana.WeatherStarter" -Dexec.args="arg1 arg2 arg3"


During the implementation of the project I had two main issues:

-My project created an error every time i tried to package, as compilation failed
    this happened due to the external artifacts (dependecies) not being loaded correctly:
        Check POM.xml to make sure the implementation is correct
        Clear Cache on your IDE (Ctrl + Shift + P : Clear Editor History)

-My CLI executed the project correctly while my IDE created an error everytime I tried to run it:
    make sure you're using the CMD terminal on your IDE to run the project instead of the powershell



Terminology:

¹Maven archetype: "Maven project templating toolkit". An archetype is defined as an original pattern or model from which all other things of the same kind are made. This feature provides a consistent means of generating Maven projects

²groupId: unique base name of the company or group that created the project. It is recommended that it follows Java's package name rules.

³artifactId: unique name of the project. Has to be lowercase and with no strange symbols

⁴pom.xml: Project Object Model. The pom.xml file contains information of project and configuration information for maven to build the project such as dependencies, build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes the goal.

⁵Retrofit: Square’s Retrofit is a type-safe HTTP client for Java, that allows mapping an external REST API into a local (Java) interface

⁶Gson: Google’s Gson is a Java library that can be used to convert Java Objects into their JSON representation.







