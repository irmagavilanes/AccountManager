FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} account-operations-manager.jar
ENTRYPOINT ["java","-jar","/account-operations-manager.jar"]