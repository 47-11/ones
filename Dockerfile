FROM openjdk:16

WORKDIR /opt/ones

COPY ./target/ones-backend.jar ./

EXPOSE 8080

CMD ["java", "-jar", "./ones-backend.jar"]
