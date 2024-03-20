#### SpringBoot-Microservices

#### Microservices Communication
- Synchronous communication -> Send a request and wait for a response from the service.
- Synchronous method: `Rest-template`, `webClient` and `OpenFeign` =  protocol is `http/https`.
- Asynchronous communication -> uses `message brokers` like `RabbitMQ` or `Apache Kafka`.
##### Rest Template
- Mapping communication between services
- Create a field in the JPA Entity and a class DTO.
- Configure RestTemplate as Spring Bean, then Inject and use the RestTemplate to make REST API calls.
##### WebClient
- Add Spring webFlux dependency, configure WebClient as spring Bean
- Inject and use WebClient to call the REST API and test with Postman.
##### Spring Cloud OpenFeign
- Declarative REST Client -> dynamic implementation of an interface decorated with spring MVC annotations.
- Add dependencies, enableFeignClients and create a feign API client.
##### Service-Registry 
- Runs multiple instances of services without hardcoding their hostnames or port numbers.
- Spring Cloud Netflix Eureka project creates a service registry and discovery.
- Create a Java Project Maven with Eureka Server and run the project `Eureka`:`http://localhost:8761`.
- Eureka Discovery Client: Display all the available instances 
- Multiple instances: Create a `JAR file` and run it on a different `PORT`.
- `AUTOSCALING`: Project Folder than run `mvn clean install` to build a SNAPSHOT.jar file & run it.  
- Run the create instance on a new port by `java -jar -Dserver.port=8083 target/department-service-0.0.1-SNAPSHOT.jar `