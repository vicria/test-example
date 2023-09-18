FROM openjdk:11
RUN mkdir /app
COPY microservice.jar /app/rest.jar
WORKDIR /app
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "rest.jar"]
