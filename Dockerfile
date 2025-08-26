# Этап 1 - сборка проекта в jar
FROM maven:3.6.3-openjdk-17 as maven
RUN mkdir job4j_tracker
WORKDIR job4j_tracker
COPY . .
RUN mvn install -Dmaven.test.skip=true

# Этап 2 - запуск поекта
FROM openjdk:17.0.2-jdk
WORKDIR job4j_tracker
COPY --from=maven /job4j_tracker/target/tracker.jar tracker.jar
CMD ["mvn", "liquibase:update", "-Pdocker"]
CMD ["java", "-jar", "tracker.jar"]