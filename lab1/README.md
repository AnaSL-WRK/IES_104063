# Lab 1 Team practices for enterprise Java development

## Learning objectives: 
This lab addresses the basic practices to set up a development environment that facilitates
cooperative development for enterprise Java projects, specifically:
- use a build tool to configure the development project and automatically manage dependencies.
- collaborate in code projects using git.
- apply a container technology (Docker) to create reusable deployments

<br>

This folder <ins>Lab1</ins> is composed by a subfolder for each of the labs section, each one including it's own README file about it's topic:
- Lab 1.1's topics were divided for lab1.2's and lab1.3's README files since they were the setup process for each topic
- [Lab 1.2](/lab1/lab1.2): Build management with the Maven tool
- [Lab 1.3](/lab1/lab1.3): Source code management using Git
- [Lab 1.4](/lab1/lab1.4): Introduction to Docker
- [Lab 1.5](/lab1/lab1.5): Wrapping-up & integrating concepts


## Review questions

**A) Maven has three lifecycles: clean, site and default. Explain the main phases in the default lifecycle.**
<br>

The **default** lifecycle handles the project deployment and its composed of 23 phases, as it is the main build lifecycle.
The most important ones from this lifecycle are: 

- <ins> validate </ins>: checks if the project is correct and all necessary information for the build is available
- <ins> compile </ins>: compiles the source code of the project
- <ins> test </ins>: tests the compiled source code using a suitable unit testing framework.
- <ins> package </ins>: takes the compiled code and packages it in its distributable format, such as a JAR.
- <ins> integration-test </ins>: processes and deploys the package if needed to run integration tests
- <ins> verify </ins>: runs any checks on results of integration tests to ensure quality criteria are met
- <ins> install </ins>: installs the package into the local repository, for use as a dependency in other projects locally
- <ins> deploy </ins>: done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

___

**B) Maven is a build tool; is it appropriate to run your project to?**
<br>

Yes, it is. Maven's main purpose is to build and manage any Java-based project, while also including dependency management with automatic updating.

___
**C) What would be a likely sequence of Git commands required to contribute with a new feature to a given project? (i.e., get a fresh copy, develop some increment, post back the added functionality)**
<br>

``` 
    git pull <remote>  
    git add  <name of file>
    git commit -m <description of changes>
    git push
```     
 
 ___
 
**D) There are strong opinions on how to write Git commit messages… Find some best practices online and give your own informed recommendations on how to write good commit messages (in a team project).**
<br>

Proper commit messages will make it easy to understand why a change has been made at a particular time. With this, maintainers of a project will easily be able to make changes later because they understand the code.

There are 7 generalized rules to write a good Git commit message:
- Separate subject from body with a blank line
- Limit the subject line to 50 characters
- Capitalize the subject line
- Do not end the subject line with a period
- Use the imperative mood in the subject line
- Wrap the body at 72 characters
- Use the body to explain what and why vs. how

Commit messages have to descriptive of the work you have committed like in these cases:
- If you fixed bugs on a file you should include a description of what the bug was and what you did
- When updating a file you have to be descriptive of the changes you did
- Using a universal language understood by everyone on your team

> You should also avoid commiting half way through the job, only commit when the file is done.

___
**E) Docker automatically prepares the required volume space as you start a container. Why is it important that you take an extra step configuring the volumes for a (production) database?** 

Configuring the volumes for a database enables you to share data among multiple running containers. If you don’t explicitly create it, Docker automatically creates it the first time it is mounted into a container. The volume will still exist even after the container has been deleted, they are only removed when you explicitly remove them.

Volumes help you with: 
- decoupling the configuration of the Docker host from the container runtime
- storing your container’s data on a remote host or a cloud provider, rather than locally
- backing up, restoring, or migrating data from one Docker host to another

Among other things, being extremelly beneficial to take the extra step configuring them.
