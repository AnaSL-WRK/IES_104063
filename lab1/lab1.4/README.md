# 1.4 Introduction to Docker 

## Why use [Docker](https://www.docker.com)?
Developers can create containers without Docker, but the platform makes it easier, simpler, and safer to build, deploy and manage containers. Docker is essentially a toolkit that enables developers to build, deploy, run, update, and stop containers using simple commands and work-saving automation through a single API.


## Installing Docker and creating a container

Useful tutorial: [Docker: Get Started](https://docs.docker.com/get-started/)

> You can follow this [tutorial](https://docs.docker.com/desktop/install/windows-install/) for the instalation process, take note to install using the WSL 2 Backend.

After installing, you can run the following code on you CLI:

```docker run -d -p 80:80 docker/getting-started```

What this did: 
- d - Run the container in detached mode (in the background).
- -p 80:80 - Map port 80 of the host to port 80 in the container[^1].
- docker/getting-started - Specify the image[^2] to use.

[^1]: Container: standardized unit which can be created on the fly to deploy a particular application or environment. It could be an Ubuntu container, CentOs container, etc. to full-fill the requirement from an operating system point of view. You can find a good example of use under the section "What is Docker & Docker Container ?" of this [site](https://www.edureka.co/blog/what-is-docker-container)

[^2] Container Image: When running a container, it uses an isolated filesystem. This custom filesystem is provided by a container image. Since the image contains the container’s filesystem, it must contain everything needed to run an application - all dependencies, configurations, scripts, binaries, etc. The image also contains other configuration for the container, such as environment variables, a default command to run, and other metadata.

> Mapping port 80 of the host to port 80 in th container makes it accessible at http://localhost:80
> If you already have a service listening on port 80 on your host machine, you can specify another port. 
> For example, specify -p 3000:80 and then access the tutorial via a web browser at http://localhost:3000
 
<br>

It is recommended to get familiar with the <ins>Docker Dashboard</ins> since it provides a simple interface that enables you to manage your containers, applications, and images directly from your machine without having to use the CLI to perform core actions.

