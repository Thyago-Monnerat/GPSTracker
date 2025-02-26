FROM openjdk:17-jdk-slim

COPY ./target/kafkaConsumer-0.0.1-SNAPSHOT.jar /app/kafkaConsumer.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/kafkaConsumer.jar"]