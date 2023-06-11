FROM adoptopenjdk/openjdk19
ARG JAR_FILE=AutomotivePartsE-Commerce-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} AutomotivePartsE-Commerce.jar
ENTRYPOINT ["java","-jar","/AutomotivePartsE-Commerce.jar"]