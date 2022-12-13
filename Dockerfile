FROM openjdk:20-ea-11-slim
RUN apt-get update && apt-get install -y curl
WORKDIR /app
COPY target/quadratic-equation-0.0.1-SNAPSHOT.jar service.jar
ENTRYPOINT ["java", "-jar", "./service.jar"]
CMD ["noname"]
EXPOSE 8000


