# spring-boot-jpa-streamer

JPAstreamer is a library for expressing JPA/Hibernate/Spring queries using
standard [Java streams](https://howtodoinjava.com/java/stream/java-streams-by-examples/). It helps in fetching and
processing the database records in the same way as we process the POJOs.

For example, we can fetch all inactive users from the database using the following code:

```shell
List<User> inactiveUsers = jpaStreamer.stream(User.class)
        .filter(u -> !u.getActive())
        .collect(Collectors.toList());
```

Internally, JPAstreamer will generate an optimized SQL query that will run in the database using the datasource/entity
manager configured in the application.

Check this out: https://jpastreamer.org/

### Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-jpa-streamer.git`
2. Navigate to the folder: `cd spring-boot-jpa-streamer`
3. Run this command to generate resources: `mvn clean compile`
4. Run the test: `mvn clean test`
5. Runt the application: `mvn clean spring-boot:run`
6. Check console log:

```shell
2024-06-14T20:00:30.213+07:00  INFO 69070 --- [spring-boot-jpa-streamer] [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
   _________  ___      _                                      
  |_  | ___ \/ _ \    | |                                     
    | | |_/ / /_\ \___| |_ _ __ ___  __ _ _ __ ___   ___ _ __ 
    | |  __/|  _  / __| __| '__/ _ \/ _` | '_ ` _ \ / _ \ '__|
/\__/ / |   | | | \__ \ |_| | |  __/ (_| | | | | | |  __/ |   
\____/\_|   \_| |_/___/\__|_|  \___|\__,_|_| |_| |_|\___|_|
:: JPAstreamer Open Source :: 3.0.4
Copyright Speedment, Inc.
Licensed under LGPL 2.1
Running under OpenJDK Runtime Environment 21.0.1+12-LTS
2024-06-14T20:00:30.233+07:00  WARN 69070 --- [spring-boot-jpa-streamer] [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2024-06-14T20:00:30.418+07:00  INFO 69070 --- [spring-boot-jpa-streamer] [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2024-06-14T20:00:30.434+07:00  INFO 69070 --- [spring-boot-jpa-streamer] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-06-14T20:00:30.438+07:00  INFO 69070 --- [spring-boot-jpa-streamer] [  restartedMain] i.m.h.p.SpringBootJpaStreamerApplication : Started SpringBootJpaStreamerApplication in 1.479 seconds (process running for 1.759)

```
