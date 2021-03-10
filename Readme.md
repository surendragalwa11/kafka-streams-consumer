# Getting Started

**Step-1**\
Navigate to the root directory of the project and run the below command

```aidl
mvn clean install
```

**Step-2**\
Run the below command to build the docker image
```aidl
kafka_stream_consumer
```

**Step-3**\
Run the below command to launch the application
```aidl
docker-compose -f src/main/docker/docker-compose-consumer.yml up
```


### Reference Documentation
For further reference, please consider the following sections:

* [Kafka Binary for Command Line Tools](https://kafka.apache.org/downloads)



### Create Kakfka topic with 3 Partitions
```
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 3 --topic test

```

### Delete Kafka Topic
```aidl
bin/kafka-topics.sh --delete --zookeeper localhost:2181 --topic test
```

### Describe Kafka Topic
```aidl
bin/kafka-topics.sh --describe --topic test --bootstrap-server localhost:9092
```

### Send messages over a kafka topic
```aidl
bin/kafka-console-producer.sh --topic test --bootstrap-server localhost:9092 
```

### Receive messages over a kafka topic
```aidl
bin/kafka-console-consumer.sh --topic test --bootstrap-server localhost:9092 
```