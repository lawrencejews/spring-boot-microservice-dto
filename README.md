#### SpringBoot-Microservices

##### Microservices Communication
- Synchronous communication -> Send a request and wait for a response from the service.
- Synchronous method: `Rest-template`, `webClient` and `OpenFeign` =  protocol is `http/https`.
- Asynchronous communication -> uses `message brokers` like `RabbitMQ` or `Apache Kafka`.
##### Rest Template
- Mapping communication between services
- Create a field in the JPA Entity and a class DTO.
- Configure RestTemplate as Spring Bean, then Inject and use the RestTemplate to make REST API calls.
##### WebClient
- Add Spring webFlux dependency, configure WebClient as Spring Bean
- Inject and use WebClient to call the REST API and test with Postman.
##### Spring Cloud OpenFeign
- Declarative REST Client -> dynamic implementation of an interface decorated with spring MVC annotations.
- Add dependencies, enableFeignClients and create a Feign API client.
##### Service-Registry 
- Runs multiple instances of services without hardcoding their hostnames or port numbers.
- Spring Cloud Netflix Eureka project creates a service registry and discovery.
- Create a Java Project Maven with Eureka Server and run the project `Eureka`:`http://localhost:8761`.
- Eureka Discovery Client: Display all the available instances 
- Multiple instances: Create a `JAR file` and run it on a different `PORT`.
- `AUTOSCALING`: Project Folder than run `mvn clean install` to build a SNAPSHOT.jar file & run it.  
- Run the create instance on a new port by `java -jar -Dserver.port=8083 target/department-service-0.0.1-SNAPSHOT.jar `
##### Spring Cloud Gateway
- Provides libraries for building an API Gateway on top of Spring WebFlux or Spring WebMVC.
- Route Request, Load balancing and Security to controls User Authentication.
- ERROR: with API-GATEWAY dependencies -> from ` <artifactId>spring-cloud-starter-gateway-mvc</artifactId>   ` to `<artifactId>spring-cloud-starter-gateway</artifactId>  `.
##### Config-Server 
- The config-server stores all the configuration files for other services which are kept in a github repository.
- Add Config Client and Spring Boot Actuator to the other services.
- Migrate service configurations to new github: `https://github.com/lawrencejews/spring-boot-config-server`.
- Create a `Refresh class` for the services and add them to the `config-server github repository`.
###### Spring Cloud Bus
- Links nodes of a distributed system with a lightweight message broker.  
- Tell the message broker to call an `actuator endpoint bus` to enable refresh for all services in the configurations.
- Add dependencies to services: `RabbitMQ` message broker using docker.`docker pull rabbitmq:3.11.0`
- Run docker for RabbitMQ `docker run --rm -it -p 5672:5672 rabbitmq:3.11.0`.
##### Distributed Tracing -> Zipkin
- micrometer-observation dependency will allow us to collect and report metrics from our application to Zipkin.
- micrometer-tracing-bridge-brave dependency will allow us to trace our spring boot application.
- zipkin-reporter-brave dependency allows us to send traces that we collect to Zipkin.
- feign-micrometer dependency was added because I am using feign in my microservices to call other APIs. This dependency will configure the micrometer to work with feign.
- Download the Zipkin latest release executable jar: `curl -sSL https://zipkin.io/quickstart.sh | bash -s` and run `java -jar  zipkin-server-3.1.1-exec.jar`.
