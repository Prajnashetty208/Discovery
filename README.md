etting up DiscoveryClient for OrderService application

Setting up the dependency

 <dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

Create a bootstrap.yaml file inside src/main/resources directory
Configure the spring.application.name, spring.profiles.active and spring.cloud.config.uri to point to config server

spring:
  application:
    name: orderservice
  profiles:
    active: qa
  cloud:
    config:
      uri: http://localhost:8888

Move all the configurations from src/main/resources to orderservice under gitlab which is managed by config server

In the application.properties add the below configuration specific to Eureka server

eureka.instance.preferIpAddress = true
eureka.client.registerWithEureka = true
eureka.client.fetchRegistry = true
eureka.client.serviceUrl.defaultZone = http://localhost:8761/eureka/
server.port=8222


Start the Config server, Eureka Server and OrderService application. You should be able to access the application pointing to QA profile


Verify if the ORDERSERVICE is showing up in the Eureka dashboard


Hit the http://localhost:8761/eureka/apps in the browser and you should see the details in json format
