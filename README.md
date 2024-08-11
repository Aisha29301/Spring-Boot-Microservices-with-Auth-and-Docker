# Spring Boot Microservices with Auth and Docker

This project demonstrates the implementation of authentication in Spring Boot microservices and shows how to containerize and run these services using Docker.

## Project Structure

- **auth-service**: Handles authentication.
- **cloud-gateway**: API Gateway for routing requests.
- **user-service**: Manages user-related operations.
- **service-registry**: Service registry for service discovery.

## Prerequisites

- **Docker**: Make sure Docker is installed on your machine. [Get Docker](https://docs.docker.com/get-docker/)
- **Docker Compose**: Required for orchestrating multi-container Docker applications. [Get Docker Compose](https://docs.docker.com/compose/install/)
- **Java 17**: Ensure Java is installed if you want to run the services without Docker. [Get Java](https://adoptopenjdk.net/)

## Running the Project

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/spring-boot-microservices-auth-docker.git
cd spring-boot-microservices-auth-docker/Microservices
```
### 2. Build the Services

```bash
cd auth-service
docker build -t auth-service .

cd ../cloud-gateway
docker build -t cloud-gateway .

cd ../userservice
docker build -t userservice .

cd ../service-registry
docker build -t service-registry .
```

### 3. Run the Services with Docker Compose

```bash
docker-compose up -d
```

### 4. Access the Services

- API Gateway: http://localhost:8080
- Auth Service: http://localhost:8081
- User Service: http://localhost:8082
- Service Registry: http://localhost:8761 (if using Eureka or similar)

### 5. Stopping the Services

```bash
docker-compose down
```
### 6. Running Without Docker(Optional)




