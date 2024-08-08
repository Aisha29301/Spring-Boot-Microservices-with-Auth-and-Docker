FROM openjdk:17
EXPOSE 8761
ADD target/docker-service-registry.jar docker-service-registry.jar
ENTRYPOINT ["java", "-jar", "docker-service-registry.jar"]

