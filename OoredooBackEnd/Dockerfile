FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} ooredoo.jar

ENTRYPOINT ["java","-jar","/ooredoo.jar"]

EXPOSE 8080