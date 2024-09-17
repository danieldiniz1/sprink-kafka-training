FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/shop-validator-0.0.1-SNAPSHOT.jar /app/shop-validator.jar
EXPOSE 8081
CMD ["java", "-jar", "/app/shop-validator.jar"]
VOLUME ["/app/data"]
LABEL authors="daniel"