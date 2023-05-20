# modern-microservice-demo
modern-microservice-demo

It's a production grade end to end microservice architecture with respective to Online shopping cart example.

It uses a Spring cloud most of commen design patterns. https://spring.io/projects/spring-cloud#samples

- [ ] Multiple services with different databases - NoSql, SQL
- [ ] Distributed/versioned configuration
- [ ] Service registration and discovery
- [ ] Service-to-service calls(sync/ async[Kafka & Rabbit MQ])
- [ ] Load balancing - API Gateway
- [ ] Circuit Breakers - 
- [ ] Distributed messaging/tracing -  
- [ ] Keycloak- Auth Server- user federation, strong authentication to services - https://www.keycloak.org/
- [ ] Event Driven Arch
- [ ] Centralised logging

**Step 1: Create Product- service**

Create simple service with Create product category with products and fetch all products through REST API
- Install MongoDB from Docker 
- 1 : Server - commands to run
  docker pull mongo
  docker run -d -p 27023:27017 --name mongodb_local mongo
- 2 : Client - https://www.mongodb.com/try/download/compass
<img width="1054" alt="image" src="https://github.com/girish-thetechieguy/modern-microservice-demo/assets/78775818/7c084406-c816-4eb9-8b95-c70d48564e9e">

