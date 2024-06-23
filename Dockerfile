FROM openjdk:21

ARG JAR_FILE=build/lib/*.jar
COPY ${JAR_FILE} mony-app.jar
ENTRYPOINT["java","-jar","/mony-app.jar"]