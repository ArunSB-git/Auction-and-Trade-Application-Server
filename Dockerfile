# Build Stage
FROM eclipse-temurin:21-jdk-alpine as build
COPY . .
RUN mvn clean package -DskipTests

# Runtime Stage
FROM openjdk:21-jdk-slim
COPY --from=build /target/*.jar api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]
