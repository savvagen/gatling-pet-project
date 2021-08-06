package com.example.simulations

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class TestSimulation extends Simulation {

  var httpConf: HttpProtocolBuilder = http.baseUrl("http://localhost:8080")
    .acceptCharsetHeader("utf-8")
    .disableWarmUp

  val testScn: ScenarioBuilder = scenario("Hello World Scenario")
    .exec(
      http("GET /").get("/")
        .check(status.is(200))
        .check(bodyString.is("Hello World!"))
    )

  setUp(testScn.inject(constantUsersPerSec(20) during(5.minutes))
    .throttle(
      reachRps(10) in(20 seconds),
      holdFor(5.minutes)
    ))
    .maxDuration(5.minutes)
    .protocols(httpConf)

}
