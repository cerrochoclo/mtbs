FROM openjdk:21-slim
WORKDIR /app
COPY /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]