package spring.servlet;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.time.Duration;

public class RampUsersServletAPISimulation extends Simulation {

    // Add the HttpProtocolBuilder:
    HttpProtocolBuilder httpProtocol =
            http.baseUrl("http://localhost:8080").acceptHeader("application/json");

    // Add the ScenarioBuilder:
    ScenarioBuilder myScenario = scenario("Get Books")
            .exec(http("Ramp Users - List Books").get("/books").check(status().is(200)));

    {
        setUp(
                myScenario.injectOpen(rampUsers(500).during(Duration.ofSeconds(10))) // 100 users over 10 sec
        ).protocols(httpProtocol);
    }
}