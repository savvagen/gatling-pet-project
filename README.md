## 1. Application and Monitoring Setup:
 - `git clone https://github.com/savvagen/gatling-pet-project.git`
 - `docker-compose buid`
 - `docker-compose up -d`

Now application is available by: http://127.0.0.1:8080/

Expected Output:
``` 
Hello World!
```

## 2. Running 5 min. Load Test

1. Running manually: `src/gatling/com/example/GatlingRunner.scala` file.
3. Running with Gradle: `./gradlew clean gatlingRun`

## 3. Watch App side and Server side metrics:
* Grafana - [Gatling Detailed Report](http://localhost:3000/d/gatling/gatling-report-detailed?orgId=1&var-ds=Gatling_TCP&var-archive=autogen&var-g=1s&var-duration_1=40&var-duration_2=100&var-simulation=testsimulation&var-run=test&var-host=localhost&var-group1=All&var-group2=All&var-group3=All&var-request=&var-scenario=All&var-Total=346&var-gatlingWriteDuration=1&var-testDuration=40&var-testDurationX2=80&from=now-30m&to=now)
* Grafana - [Light Report](http://localhost:3000/d/u/gatling-lite?orgId=1)
* Grafana - [Node Exporter Metrics](http://localhost:3000/d/rYdddlPWk/node-exporter-full?orgId=1&refresh=1m&from=now-30m&to=now)

## 4. Environment cleanup:
* navigate to `gatling-pet-project` folder
* run command `docker-compose down`