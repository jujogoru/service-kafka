FROM openjdk:12
VOLUME /tmp
EXPOSE 8090
ADD ./target/service-kafka-0.0.1-SNAPSHOT.jar service-kafka.jar
ENTRYPOINT ["java","-jar","/service-kafka.jar"]