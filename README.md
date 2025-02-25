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

## Load Test

For the load test, I'm using [Gatling with Java](https://docs.gatling.io/tutorials/scripting-intro/).

### Ramp User Simulation

- Gatling starts 500 virtual users over 10 seconds.
- Each user sends a GET request to /books.

![](gatling-load-tests/screenshots/ramp_users_1.png)
![](gatling-load-tests/screenshots/ramp_users_2.png)
![](gatling-load-tests/screenshots/ramp_users_3.png)







