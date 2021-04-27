FROM adoptopenjdk:16-jre-openj9

WORKDIR /opt/ones

COPY ./ones-webapp/target/ones-webapp.jar ./

EXPOSE 8080

CMD ["java", "-jar", "-Dspring.profiles.active=production", "-Dspring.config.location=classpath:/,/config/", "./ones-backend.jar"]
