FROM java:8
VOLUME /tmp
EXPOSE 8088
ADD target/spring-boot-docker-microservice-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]