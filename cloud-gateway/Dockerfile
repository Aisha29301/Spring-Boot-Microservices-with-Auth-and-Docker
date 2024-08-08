FROM openjdk:17
EXPOSE 8080
ADD target/docker-cloud-gateway.jar docker-cloud-gateway.jar
ENTRYPOINT ["java", "-jar", "docker-cloud-gateway.jar"]