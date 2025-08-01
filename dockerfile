# Dockerfile
FROM eclipse-temurin:23-jdk-alpine

WORKDIR /app

COPY target/erp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
