# Build Stage
FROM maven:3.9.9-openjdk-21 as build
COPY . .
RUN mvn clean package -DskipTests

# Runtime Stage
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /target/*.jar api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]
