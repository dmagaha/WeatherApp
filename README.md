# WeatherApp



**Description**: Java app, that calls a Weather REST service. Current state: POC.



**Technology stack**:



-   JDK 11

-   Weather REST service (http://api.openweathermap.org/data/2.5/weather)



**Status**: Work in progress (WIP), not production ready.



## Dependencies



The following dependencies are required to build, test and run the project:



-   Gradle 6+

-   JDK 11+



## Running development environment



### Build and Run application



At the top-level of the code base, use the gradle wrapper to build and run application.

```

./gradlew build

```

```

./gradlew run --args='-z 21787'

```
