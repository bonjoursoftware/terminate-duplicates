FROM gradle:5.6.0-jdk8 AS builder
WORKDIR /home/gradle/project
COPY settings.gradle ./
COPY build.gradle ./
COPY src/ ./src/
RUN gradle jar

FROM openjdk:8-jre-alpine
WORKDIR /home/app/
COPY --from=builder /home/gradle/project/build/libs/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]