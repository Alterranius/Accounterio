FROM maven:3.8-openjdk-17-slim  AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip

FROM openjdk:17-oracle
COPY --from=build /home/app/target/accounterio_core-0.0.1-SNAPSHOT.jar /usr/local/lib/accounterio_core.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/accounterio_core.jar"]