FROM openjdk:17
EXPOSE 8082
ADD target/docker-auth-service.jar docker-auth-service.jar
ENTRYPOINT ["java", "-jar", "docker-auth-service.jar"]