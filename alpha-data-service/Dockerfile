# Stage 1: Build the application
FROM jelastic/maven:3.9.5-openjdk-21 AS builder

# Set the working directory in the container
WORKDIR /alpha-data-service

# Copy the project files to the working directory
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package

# Stage 2: Run the application
FROM openjdk:21-slim

# Set the working directory in the container
WORKDIR /alpha-data-service

# Copy the executable jar file from the builder stage to the runtime stage
COPY --from=builder /alpha-data-service/target/alpha-data-service-0.0.1-SNAPSHOT.jar /alpha-data-service/alpha-data-service-0.0.1-SNAPSHOT.jar

# Expose the port your application runs on
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java", "-jar", "alpha-data-service-0.0.1-SNAPSHOT.jar"]