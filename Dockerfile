FROM adoptopenjdk:16-jre-openj9

WORKDIR /opt/ones

COPY ./target/ones-backend.jar ./

EXPOSE 8080

CMD ["java", "-jar", "./ones-backend.jar"]
