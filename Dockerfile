FROM bellsoft/liberica-openjdk-debian:17
MAINTAINER Olga
COPY target/dg-users-0.0.1-SNAPSHOT.jar dg-users.jar
ENTRYPOINT ["java","-jar","/dg-users.jar"]
