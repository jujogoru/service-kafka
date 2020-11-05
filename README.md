# service-kafka

Microservice for Kafka messages.

### Setup

Follow the next commands to generate the server image:

### Generate jar

```bash
$ ./mvnw clean package -DskipTests
```

#### Run Zookeeper

```bash
$ docker run -d \
    --net=host \
    --name=zookeeper \
    --rm \
    zookeeper:3.5.6
```

#### Run Apache Kafka

```bash
$ docker run -d \
    --net=host \
    --name=kafka \
    --rm \
    -e KAFKA_ZOOKEEPER_CONNECT=localhost:2181 \
    -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
    -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 \
    confluentinc/cp-kafka:5.3.0
```

### Generate image

```bash
$ docker build -t service-kafka:v1 .
```

### Run the service

```bash
$ docker run -d -p 8090:8090 --name service-kafka --net=host service-kafka:v1
```

### Logs

```bash
$ docker logs -f service-kafka
```

### Send message (ticker) to consumer
```bash
$ curl -X POST -F 'ticker=AMZN' http://localhost:8090/api/v1/notifications/tickers
```