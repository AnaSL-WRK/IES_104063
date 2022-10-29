FROM eclipse-temurin:17-jdk-alpine
ADD target/quotesapi-0.0.1-SNAPSHOT.jar quotesapi-docker.jar
VOLUME /tmp
ARG JAR_FILE
ENTRYPOINT ["java","-jar","quotesapi-docker.jar"]