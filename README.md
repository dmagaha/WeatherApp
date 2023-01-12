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
#Running the code without the zip parameter being passed in.
(base) davidmagaha@Davids-MacBook-Pro WeatherApp % ./gradlew run                  

> Task :run
Missing required option: z
usage: Usage:
 -z,--zip <zip>   Zip to query with

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.8/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 660ms
3 actionable tasks: 1 executed, 2 up-to-date
(base) davidmagaha@Davids-MacBook-Pro WeatherApp
```

```
#Running the code with the zip parameter being passed in.
./gradlew run --args='-z 21787'

(base) davidmagaha@Davids-MacBook-Pro WeatherApp % ./gradlew run --args='-z 21787'

> Task :run
{
  "coord" : {
    "lon" : -77.1691,
    "lat" : 39.6658
  },
  "weather" : [ {
    "id" : 804,
    "main" : "Clouds",
    "description" : "overcast clouds",
    "icon" : "04n"
  } ],
  "base" : "stations",
  "main" : {
    "temp" : 277.16,
    "feels_like" : 274.04,
    "temp_min" : 276.02,
    "temp_max" : 278.57,
    "pressure" : 1020,
    "humidity" : 79
  },
  "visibility" : 10000,
  "wind" : {
    "speed" : 3.6,
    "deg" : 140
  },
  "clouds" : {
    "all" : 100
  },
  "dt" : 1673492489,
  "sys" : {
    "type" : 2,
    "id" : 2019867,
    "country" : "US",
    "sunrise" : 1673440136,
    "sunset" : 1673474620
  },
  "timezone" : -18000,
  "id" : 0,
  "name" : "Taneytown",
  "cod" : 200
}

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.8/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 6s
3 actionable tasks: 1 executed, 2 up-to-date
(base) davidmagaha@Davids-MacBook-Pro WeatherApp
```
