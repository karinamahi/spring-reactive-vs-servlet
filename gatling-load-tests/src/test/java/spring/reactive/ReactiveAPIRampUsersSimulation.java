package spring.reactive;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.rampUsers;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class RampUsersReactiveAPISimulation extends Simulation {

    // Add the HttpProtocolBuilder:
    HttpProtocolBuilder httpProtocol =
            http.baseUrl("http://localhost:8081").acceptHeader("application/json");

    // Add the ScenarioBuilder:
    ScenarioBuilder myScenario = scenario("Get Books")
            .exec(http("Ramp Users - List Books").get("/books").check(status().is(200)));

    {
        setUp(
                myScenario.injectOpen(rampUsers(500).during(Duration.ofSeconds(10))) // 100 users over 10 sec
        ).protocols(httpProtocol);
    }
}