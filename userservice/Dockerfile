FROM openjdk:17
EXPOSE 8081
ADD target/docker-user-service.jar docker-user-service.jar
ENTRYPOINT ["java", "-jar", "docker-user-service.jar"]