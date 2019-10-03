FROM gradle:5.6.2-jdk8 AS builder
WORKDIR /home/gradle/project
COPY settings.gradle ./
COPY build.gradle ./
RUN gradle build --no-daemon --info --gradle-user-home ./
COPY src/ ./src/
RUN gradle jar --no-daemon --offline --info --gradle-user-home ./

FROM openjdk:8-jre-alpine
WORKDIR /home/app/
COPY --from=builder /home/gradle/project/build/libs/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]