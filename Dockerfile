#
# Build stage
# docker run -it --name covid -v "$(pwd)":/usr/src/covid -w /usr/src/covid maven:3.6.1-openjdk-11 mvn clean install
# docker build -t demo .
FROM maven:3.6.3-openjdk-11 AS build
COPY . /usr/covid
COPY pom.xml /usr/covid
#RUN git clone covid https://github.com/ignacioaniball/covid
WORKDIR /usr/covid
RUN mvn -X clean package -DskipTests
#RUN mvnw spring-boot:run

# Package stage
# docker run --rm -it demo:latest
FROM openjdk:11-jre
COPY --from=build /usr/covid/target/microservicio-0.0.1-SNAPSHOT.war /usr/local/lib
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/microservicio-0.0.1-SNAPSHOT.war"]
