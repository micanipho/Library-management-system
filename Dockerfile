# Build stage
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml first for better layer caching
COPY pom.xml .
# Download all dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080