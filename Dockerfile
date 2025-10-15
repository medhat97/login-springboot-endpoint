# Use an official OpenJDK runtime as a parent image
FROM maven:3.8.5-openjdk-17 AS build

COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/*.jar demo.jar 
# Expose the port your Spring Boot app runs on (default is 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "demo.jar"]