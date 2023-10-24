FROM maven:3-amazoncorretto-21-debian  AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -Dmaven.test.skip

FROM openjdk:21-oracle
COPY --from=build /home/app/target/receiptai_processor-0.0.1-SNAPSHOT.jar /usr/local/lib/receiptai_processor.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/receiptai_processor.jar"]