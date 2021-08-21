#FROM openjdk:8-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]


# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:8-jre-alpine3.9

# we will use port 9090 for our application
EXPOSE 9090

# copy the packaged jar file into our docker image
COPY target/home-assignment-0.0.1-SNAPSHOT.jar /Bottomline.autocomplete.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/Bottomline.autocomplete.jar"]
