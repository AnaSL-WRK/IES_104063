# 1.4 Introduction to Docker 

## Why use [Docker](https://www.docker.com)?
Developers can create containers without Docker, but the platform makes it easier, simpler, and safer to build, deploy and manage containers. Docker is essentially a toolkit that enables developers to build, deploy, run, update, and stop containers using simple commands and work-saving automation through a single API.


## Installing Docker and creating a container

Useful tutorial: [Docker: Get Started](https://docs.docker.com/get-started/)

> You can follow this [tutorial](https://docs.docker.com/desktop/install/windows-install/) for the instalation process, take note to install using the WSL 2 Backend.

After installing, you can run the following code on you CLI:

```docker run -d -p 80:80 docker/getting-started```

What this did: 
- ```-d``` - Run the container in detached mode (in the background).
- ```-p 80:80``` - Map port 80 of the host to port 80 in the container[^1].
- ```docker/getting-started``` - Specify the image[^2] to use.

[^1]: Container: standardized unit which can be created on the fly to deploy a particular application or environment. It could be an Ubuntu container, CentOs container, etc. to full-fill the requirement from an operating system point of view. You can find a good example of use under the section "What is Docker & Docker Container ?" of this [site](https://www.edureka.co/blog/what-is-docker-container)

[^2]: Container Image: When running a container, it uses an isolated filesystem. This custom filesystem is provided by a container image. Since the image contains the container’s filesystem, it must contain everything needed to run an application - all dependencies, configurations, scripts, binaries, etc. The image also contains other configuration for the container, such as environment variables, a default command to run, and other metadata.

> Mapping port 80 of the host to port 80 in th container makes it accessible at http://localhost:80
> If you already have a service listening on port 80 on your host machine, you can specify another port. 
> For example, specify -p 3000:80 and then access the tutorial via a web browser at http://localhost:3000
 
<br>

It is recommended to get familiar with the <ins>Docker Dashboard</ins> since it provides a simple interface that enables you to manage your containers, applications, and images directly from your machine without having to use the CLI to perform core actions.

## Downloading and Initializing Portrainer

Although Docker Desktop covers the essentials of a graphical interface for container managment, you can combine this software with [Portrainer](https://www.portainer.io)

You can install it by following this [tutorial](https://docs.portainer.io/start/intro), using the "Docker" deployment option

After installing the Portrainer Server container you can run ```docker ps``` to check if it's running

> To Log in you have to open a web browser and go to ```https://localhost:9443``` (By default, Portainer generates and uses a self-signed SSL certificate to secure port 9443 but if that site can't be reached, be sure to use the port number it was allocated as seen previously)

And you're all set up with Portrainer!


## Define your own image (Dockerfile)

We are now trying to develop (and deploy) a project that requires a database server (persistent data)
For that we are setting up PostgreSQL[^3]
<br>

 ```docker pull postgres``` will pull down the latest stable release Postgres image from the official Postgres docker hub repository.

[^3]: PostgreSQL is relational database management system, used as the primary data store or data warehouse for many web, mobile, geospatial, and analytics applications

```docker run --name pg-docker -e POSTGRES_PASSWORD=docker -e POSTGRES_DB=sampledb -e PGDATA=/tmp -d -p 5432:5432 -v C:\Users\anawk\databaseDock:/var/lib/postgresql/data postgres:11``` to run the container (you may map other ports and swap the absolute path to the host location for the database storage

> use ```docker ps``` to check the container and its ports
<br>

### Connecting and using PostgreSQL

Useful tutorial: [PostgreSQL With Docker – Quick Start](https://dzone.com/articles/postgresql-with-docker-quick-start)
To run psql inside the container we can use: ```docker exec -it pg-docker psql -U postgres```

To issue SQL commands via docker CLI we can use: ```docker exec -it pg-docker psql -U postgres -c "CREATE DATABASE testdb;"```
<br>
<br>

### Docker File 

To build an image we will firstly creat a Docker File[^4]

[^4]: Docker File: a text document that contains all the commands a user could call on the command line to assemble an image.

In the folder Lab1.4 you can find example files that we are going to run

> On the dockerfile notice the **Copy** command which is copying the script files from host directory to container.

> Giving the file names numeric ascending value helps in controlling the execution order.

After having our files we can now build our image:
```docker image build -t postgresbasic .```

<br>

### Testing the access to the database

Useful tutorial: [How to run PostgreSQL using docker](https://dev.to/shree_j/how-to-install-and-run-psql-using-docker-41j2)

For the test we need a PostgresSQL client

```docker run --rm -p 5050:5050 thajeztah/pgadmin4``` to install PG-Admin using Docker

And you can now manage your postgres from the browser by launching http://localhost:5050 


## Multiple services (Docker compose)

More often than not, deployment environments required several interdependent services, mapped
into different containers. In those cases, it is convenient to define a “graph” of services and
corresponding containers, using the “Docker composer” tool.

Inside the folder lab1.4/DockerComposeApp you will find an implementation using the Docker Composer tool created by following this [tutorial](https://docs.docker.com/compose/gettingstarted/)

problems:
failed to solve with frontend dockerfile.v0: failed to read dockerfile: open /var/lib/docker/tmp/buildkit-mount608736373/Dockerfile: no such 
file or directory:  escrevi .Dockerfile em vez de Dockerfile

