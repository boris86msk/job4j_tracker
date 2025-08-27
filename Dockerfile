# Этап 1 - сборка проекта в jar
FROM maven:3.6.3-openjdk-17 as build
WORKDIR /job4j_tracker
COPY . .
RUN mvn install -Dmaven.test.skip=true
CMD ["mvn", "liquibase:update", "-Pdocker"]

# Этап 2 - запуск поекта
FROM openjdk:17.0.2-jdk
WORKDIR /job4j_tracker
COPY --from=build /job4j_tracker/target/tracker.jar tracker.jar
CMD ["java", "-jar", "tracker.jar"]