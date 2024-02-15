FROM openjdk:17-slim-buster

WORKDIR /app
COPY ./build/libs/connector-edc.jar /app

ENTRYPOINT [ "sh", "-c", "exec java $ENV_JVM_ARGS -jar connector-edc.jar"]
