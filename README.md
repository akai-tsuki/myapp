# myapp
sample app for java

## Pre Condition

1. Install Java, Maven, Tomcat
2. Get app
    git clone https://github.com/akai-tsuki/myapp.git
    cd myapp
    mvn package
3. Get redis image
    docker pull redis

## procedure

App

1. Deploy ROOT.war to Tomcat

[Redis](https://hub.docker.com/_/redis/) on Docker

1. docker run --name some-redis -d -p 6379:6379 redis redis-server --appendonly yes

Run

1. run Tomcat

Access

1. http://localhost:8080/

