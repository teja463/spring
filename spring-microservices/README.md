# MicroServices V2 URLS

## Docker Compose 

> This commands brings up all the containers. No need to start zipking separatley

```shell
docker-compose up
```

## Installing zipkin

> Execute the below command so that the microservices can log messages to zipkin

```shell
docker pull openzipkin/zipkin:2.23
docker run -dp 9411:9411 openzipkin/zipkin:2.23
```

## Currency Exchange Service

* http://localhost:8000/currency-exchange/from/USD/to/INR

## Currency Conversion Service

### Normal

* http://localhost:8100/currency-convertor/from/USD/to/INR/quantity/10

### Feign

* http://localhost:8100/currency-convertor-feign/from/USD/to/INR/quantity/10

## API Gateway

* http://localhost:8765/currency-conversion-service/currency-convertor-feign/from/USD/to/INR/quantity/23
