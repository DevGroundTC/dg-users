FROM bellsoft/liberica-openjdk-debian:17
MAINTAINER Olga
COPY target/dg-user-api-0.0.1-SNAPSHOT.jar dg-user-api.jar
ENTRYPOINT ["java","-jar","/dg-users.jar"]