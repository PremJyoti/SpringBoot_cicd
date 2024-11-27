FROM openjdk:17
EXPOSE 8080
ADD target/springboot--github.jar springboot--github.jar
ENTRYPOINT ["java","-jar","/springboot--github.jar"]