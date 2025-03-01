# Spring Reactive VS Servlet

## Introduction

While studying Java and Spring Boot, I came across [Giovana's project](https://github.com/giuliana-bezerra/spring-reactive) in which she compares the two Spring stacks: [Servlet and Reactive](https://spring.io/reactive).

I thought it would be a good idea to try doing the same on my own with a few changes.

## Implementation

Both APIs are vey similar and have two endpoints: one for saving a book and another one for listing books.
The data is saved in a PostgreSQL database.

### Servlet vs Reactive stack

| Servlet                         | Reactive                                  |
|---------------------------------|-------------------------------------------|
| Spring MVC                      | Spring WebFlux                            | 
| Spring Data Repositories - JDBC | Spring Data Reactive Repositories - R2DBC |
| H2 Database for Testing         | R2DBC H2 for Testing                      |
| TestRestTemplate for Testing    | WebTestClient for Testing                 |

## Running the applications

The following command starts both APIs and the PostgreSQL database.
```shell
docker-compose up --build -d
```

Port:
- 8080 - servlet-api
- 8181 - reactive-api
## Load Test

For the load test, I'm using [Gatling with Java](https://docs.gatling.io/tutorials/scripting-intro/).

```shell
cd gatling-load-tests
mvn gatling:test
```

### Ramp User Simulation - Locally

- Gatling starts 500 virtual users over 10 seconds.
- Each user sends a GET request to /books.

![](gatling-load-tests/screenshots/ramp_users_1.png)
![](gatling-load-tests/screenshots/ramp_users_2.png)
![](gatling-load-tests/screenshots/ramp_users_3.png)


### Ramp User Simulation - Docker

After setting up Docker and Docker Compose, I re-ran the ramp-user test just for sake of curiosity.

- Gatling starts 500 virtual users over 10 seconds.
- Each user sends a GET request to /books.

![](gatling-load-tests/screenshots/ramp_users_docker_1.png)
![](gatling-load-tests/screenshots/ramp_users_docker_2.png)
![](gatling-load-tests/screenshots/ramp_users_docker_3.png)


### Constant Users Simulation - Docker

This test simulates a steady load of 100 users per second for 5 minutes.

![](gatling-load-tests/screenshots/constant_users_docker_1.png)
![](gatling-load-tests/screenshots/constant_users_docker_2.png)
![](gatling-load-tests/screenshots/constant_users_docker_3.png)
![](gatling-load-tests/screenshots/constant_users_docker_4.png)

### Final Thoughts

In all three tests, the servlet-api performed better than the reactive API.

However, in the last test, we could clearly see that the servlet-api performed much better than the reactive-api, which is unexpected since WebFlux is designed for high-concurrency workloads.

So, the next step would be to investigate the Reactive API implementation to identify the bottleneck and fix it.
Additionally, more tests could be conducted, adjusting them to better reflect real-world scenarios.






