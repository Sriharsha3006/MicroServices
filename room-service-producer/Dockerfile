FROM java:8
EXPOSE 9080
ADD /target/room-service-producer.jar room-service-producer.jar
ENTRYPOINT ["java","-jar","room-service-producer.jar"]