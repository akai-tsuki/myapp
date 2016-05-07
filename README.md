# myapp
sample app for java

## Pre Condition

1. install Java, Maven, Tomcat
2. get app
3. docker pull redis

## procedure

App

1. mvn package
2. deploy ROOT.war to Tomcat

[Redis](https://hub.docker.com/_/redis/) on Docker

1. docker run --name some-redis -d -p 6379:6379 redis redis-server --appendonly yes

Run

1. run Tomcat

Access

1. http://localhost:8080/

