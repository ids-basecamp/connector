FROM gradle:7-jdk17 AS build

COPY --chown=gradle:gradle . /home/gradle/project/
WORKDIR /home/gradle/project/
RUN ./gradlew clean build

FROM openjdk:17-slim-buster

WORKDIR /app

COPY --from=build /home/gradle/project/launchers/connector-prod/build/libs/connector-edc.jar /app

ENTRYPOINT [ "sh", "-c", "exec java $ENV_JVM_ARGS -jar connector-edc.jar"]
