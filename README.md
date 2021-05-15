## Getting Started

### Reference Documentation
For further reference, please consider the following sections:

### Guides
The following guides illustrate how to use some features concretely:

In Dockerfile, replace api key with one provided by NASA 
```bash
ENV NASA_API_KEY=<Replace API KEY>
```

Build the Spring Boot Project with Gradle
```bash
./gradlew build
```

Build Docker Image
```bash
docker build --build-arg JAR_FILE=build/libs/\*.jar -t marsrover .
```

Run the application using docker
```bash
docker run -p 8080:8080 marsrover
```


Once the application is running, make a get request without a request parameter to pull data using the the dates in the text file
 
 ```bash
 http://localhost:8080/v1/marsrover
 ```

 To make a request any other date, make the following GET request with following formats ["MM/dd/yy", "MMMM dd, yyyy", "MMM-dd-yyyy", "yyyy-MM-dd"]  
 
 http://localhost:8080/v2/marsrover?date=<PROVIDE DATE>


### Additional Links
These additional references should also help you:

https://api.nasa.gov/


