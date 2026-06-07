FROM amazoncorretto:17.0.19-al2023

WORKDIR /app

COPY ./target/doctor-service-1.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

