# Use a base image with OpenJDK 11 installed
FROM openjdk:17-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file into the container at the specified path
COPY target/your-application.jar /app/your-application.jar

# Specify the command to run your Spring Boot application when the container starts
CMD ["java", "-jar", "your-application.jar"]
