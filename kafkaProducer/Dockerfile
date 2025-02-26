FROM openjdk:17-jdk-slim

COPY ./target/kafkaProducer-0.0.1-SNAPSHOT.jar /app/kafkaProducer.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/kafkaProducer.jar"]