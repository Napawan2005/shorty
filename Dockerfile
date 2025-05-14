# Use a lightweight JDK image
FROM ubuntu/jre:21-24.04_edge

# Create and switch to app directory
WORKDIR /app

# Copy the packaged Spring Boot jar
COPY target/shorty-application-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
