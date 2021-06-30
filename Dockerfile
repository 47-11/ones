FROM adoptopenjdk:16-jre-openj9

COPY ./ones-webapp/target/ones-webapp.jar /opt/ones/ones-webapp.jar

EXPOSE 8080

CMD ["java", "-jar", "-Dspring.profiles.active=production", "-Dspring.config.location=classpath:/,/config/", "/opt/ones/ones-webapp.jar"]
