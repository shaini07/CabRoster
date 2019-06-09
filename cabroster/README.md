# Running the project

`mvn spring-boot:run`

Wait for the application to start

Open http://localhost:8080/ to view the application.

Default credentials are admin@vaadin.com/admin for admin access and
barista@vaadin.com/barista for normal user access.

# Running the project as an executable jar

The project is configured to automatically make the build artifact runnable using `java -jar`.
By default you can thus also run the project by executing the war file:
```
java -jar target/cabroster-1.0-SNAPSHOT.war
```

If you want to produce a `jar` file instead of a `war` file, change the packaging type in `pom.xml` to `<packaging>jar</packaging>`.

# Running integration tests

Integration tests are implemented using TestBench. The tests take tens of minutes to run and are therefore included in a separate profile. To run the tests, execute

`mvn verify -Pit`

and make sure you have a valid TestBench license installed.

# Running scalability tests

Scalability tests can be run as follows

1. Configure the number of concurrent users and a suitable ramp up time in the end of the `src/test/scala/*.scala` files, e.g.:
	```setUp(scn.inject( rampUsers(50) over (60 seconds)) ).protocols(httpProtocol)```

2. If you are not running on localhost, configure the baseUrl in the beginning of the `src/test/scala/*.scala` files, e.g.:

	```val baseUrl = "http://my.server.com"```

3. Make sure the server is running at the given URL. To run the local server, use
  ```mvn spring-boot:run```

4. Start a test from the command line, e.g.:
	 ```mvn -Pscalability gatling:execute -Dgatling.simulationClass=com.blujay.Barista```

5. Test results are stored into target folder, e.g.:
	```target/gatling/Barista-1487784042461/index.html```

# Developing the project

The project can be imported into the IDE of your choice as a Maven project

The views are created using Vaadin Designer. To edit the views visually,
you need to install the Vaadin Designer plug-in.

In Eclipse, open Marketplace, search for "vaadin" and install Vaadin
Designer 2.x

In IntelliJ, go to "Preferences" -> "Plugins" -> "Browse Repositories",
search for "Vaadin Designer 2" and install "Vaadin Designer"

# License
A paid Pro or Prime subscription is required for creating a new software project from this starter. After its creation, results can be used, developed and distributed freely, but licenses for the used commercial components are required during development. The starter or its parts cannot be redistributed as a code example or template.

For full terms, see LICENSE
