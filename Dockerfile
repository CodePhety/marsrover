FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

ENV NASA_API_KEY=""
ENV NASA_BASE_URL="https://api.nasa.gov/planetary/apod"
ENV DATE_FILENAME="dates.txt"
ENV OUTPUT_FILE_NAME="roverdata.txt"
ENV DATE_FORMAT_LIST: "MM/dd/yy", "MMMM dd, yyyy", "MMM-dd-yyyy", "yyyy-MM-dd", "yyyy-dd-MM"

ENTRYPOINT ["java","-jar","/app.jar"]
