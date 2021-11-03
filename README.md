# ONES
**O**nline-**Ne**nnungs-**S**ystem

## Modules
This project consists of three modules.

### ones-webapp 
The backend application.
* Manages user accounts (registration, login, password reset)
* Loads data from / sends data to ECM via [ones-ecm-api](#ones-ecm-api)
* Provides an API used by [ones-frontend](#ones-frontend)
* Serves ones-frontend as static resources, so that we don't need a separate webserver.

### ones-ecm-api
Generated API client for accessing ECM APIs.
Code generation is done via the [openapi-generator-maven-plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin).

To regenerate this module save the latest ECM openapi spec in [ecm-api-docs.json](./ecm-api-docs.json) and run `mvn compile`.

### ones-frontend
The web interface.

## Build

To build everything run 
```
mvn package
``` 

This will build all modules and package everything in a fat .jar file that can be found at `ones-webapp/target/ones-webapp.jar`

To create a docker image run
```
docker build .
```

## Deployment

The easiest way to deploy ones is via Docker.

The docker image starts ones with the profile `production` active and looks for configuration files in `/config/`.
To override the default/placeholder properties you can place a file named `application-production.properties` in that directory (e.g. by binding it to the host file system).

You should override these properties:

| Property                                  | Default                           | Explanation 
|-------------------------------------------|-----------------------------------|------------
| `spring.datasource.url`                   | `jdbc:h2:mem:ones`                | Datasource url
| `spring.datasource.username`              | `SA`                              | Datasource username
| `spring.datasource.password`              | ` `                               | Datasource password
| `spring.datasource.driver-class-name`     | `org.h2.Driver`                   | Datasource JDBC driver
| `spring.jpa.properties.hibernate.dialect` | `org.hibernate.dialect.H2Dialect` | Datasource Hibernate dialect
| `ones.security.jwt.secret`                | `Geheim!`                         | Secret used to sign the JWTs
| `ones.message.email.host`                 | *not set*                         | SMTP host for sending E-Mails 
| `ones.message.email.port`                 | *not set*                         | SMTP port for sending E-Mails
| `ones.message.email.enable-tls`           | `true`                            | Whether to use TLS when connection to SMTP server
| `ones.message.email.username`             | *not set*                         | SMTP username
| `ones.message.email.password`             | *not set*                         | SMTP password
| `ones.message.email.sender-address`       | *not set*                         | The sender address for outgoing E-Mails
| `ones.ecm.api-base-url`                   | `http://localhost:8080/`          | ECM API base url
| `ones.ecm.api-user`                       | `admin`                           | ECM API username
| `ones.ecm.api-password`                   | *not set*                         | ECM API password

## Development

For information on the development setup for the different modules refer to their respective READMEs.
