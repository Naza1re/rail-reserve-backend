FROM gradle:8.5-jdk17 AS builder

WORKDIR /app
COPY build.gradle settings.gradle ./
COPY gradle ./gradle
COPY . .

RUN gradle bootJar --no-daemon --console=plain

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
