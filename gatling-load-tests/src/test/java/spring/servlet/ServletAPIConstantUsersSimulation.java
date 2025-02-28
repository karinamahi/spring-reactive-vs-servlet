package spring.servlet;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class ServletAPIConstantUsersSimulation extends Simulation {

    // Add the HttpProtocolBuilder:
    HttpProtocolBuilder httpProtocol =
            http.baseUrl("http://localhost:8080").acceptHeader("application/json");

    // Add the ScenarioBuilder:
    ScenarioBuilder myScenario = scenario("Get Books")
            .exec(http("Ramp Users - List Books").get("/books").check(status().is(200)));

    {
        setUp(
                myScenario.injectOpen(constantUsersPerSec(100).during(Duration.ofMinutes(5)))
        ).protocols(httpProtocol);
    }
}