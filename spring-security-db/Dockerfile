FROM openjdk:8
ADD target/security-db.jar security-db.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","security-db.jar"]