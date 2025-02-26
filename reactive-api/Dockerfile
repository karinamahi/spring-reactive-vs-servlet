# Use a lightweight Java runtime
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY target/reactive-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "app.jar"]
