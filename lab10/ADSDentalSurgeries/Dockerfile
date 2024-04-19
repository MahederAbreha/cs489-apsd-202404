FROM openjdk:21
RUN mkdir /app
COPY target/*.jar /app/ADSDentalSurgery.jar
WORKDIR /app
CMD ["java", "-jar", "ADSDentalSurgery.jar"]