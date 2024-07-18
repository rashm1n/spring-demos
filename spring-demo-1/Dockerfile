FROM maven:3.9.8-eclipse-temurin-17 as build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
RUN addgroup --gid 10014 springdemo && \
    adduser --disabled-password --no-create-home --uid 10014 --ingroup springdemo demouser
USER 10014
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
