FROM java:8
EXPOSE 8765
ADD /target/room-zuul-api-gateway.jar room-zuul-api-gateway.jar
ENTRYPOINT ["java","-jar","room-zuul-api-gateway.jar"]