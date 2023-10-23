FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./target/accounterio_core-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "accounterio_core-0.0.1-SNAPSHOT.jar"]