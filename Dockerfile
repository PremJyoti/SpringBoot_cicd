FROM openjdk:17
EXPOSE 8080
ADD target/contianerization.jar contianerization.jar
ENTRYPOINT ["java","-jar","/contianerization.jar"]