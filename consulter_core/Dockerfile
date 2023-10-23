FROM maven:3-amazoncorretto-21-debian  AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:21-oracle
COPY --from=build /home/app/target/consulter_core-0.0.1-SNAPSHOT.jar /usr/local/lib/consulter_core.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "/usr/local/lib/consulter_core.jar"]