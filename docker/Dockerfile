FROM openjdk:20

ARG APP_JAR=*.jar

COPY ${APP_JAR} AccountingOfVehicles.jar

ENTRYPOINT ["java", "-jar", "AccountingOfVehicles.jar"]

EXPOSE 8080