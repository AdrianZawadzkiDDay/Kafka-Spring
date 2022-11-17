# Kafka-Spring
Kafka in Spring examples of not enogh replicas error and consumer error handler


#### Lista sieci
##### docker run --net=course-kafka-spring-producer_default --rm -i -t confluentinc/cp-kafka:5.3.0 kafka-topics --list --zookeeper zookeeper:2181

#### Stworzenie topic
##### docker run --net=course-kafka-spring-producer_default --rm -i -t confluentinc/cp-kafka:5.3.0 kafka-topics --zookeeper zookeeper:2181 --create --topic test-topic-60 --partitions 2 --replication-factor 2

#### Stworzenie topic & min,insync.replicas
##### docker run --net=course-kafka-spring-producer_default --rm -i -t confluentinc/cp-kafka:5.3.0 kafka-topics --zookeeper zookeeper:2181 --create --topic test-topic-71 --partitions 1 --replication-factor 3 --config min.insync.replicas=3

#### Lista topików
##### docker run --net=course-kafka-spring-producer_default  --rm -i -t confluentinc/cp-kafka:5.3.0 kafka-topics --list --zookeeper zookeeper:2181

#### Opis topika
##### docker run --net=course-kafka-spring-producer_default --rm -i -t confluentinc/cp-kafka:5.3.0 kafka-topics --zookeeper zookeeper:2181 --topic test-topic-71 --describe

#### Producent wiadomości
##### docker run --net=course-kafka-spring-producer_default --rm -i -t confluentinc/cp-kafka:5.3.0 kafka-console-producer --broker-list broker3:19093 --topic test-topic-72

#### Konsument wiadomości
##### docker run --net=course-kafka-spring-producer_default --rm -i -t confluentinc/cp-kafka:5.3.0 kafka-console-consumer --bootstrap-server broker3:19093 --topic test-topic-30 --from-beginning --group group-3

### Not enough replicas error - producer
![notEnoughReplicas](https://user-images.githubusercontent.com/45298383/202521176-bf3fe536-6512-4e25-8e02-cf406cfc41c7.PNG)

### consumer error handler 
![cosumerErrorHandler](https://user-images.githubusercontent.com/45298383/202521280-67828b2d-ba90-4d26-91aa-b6fdc4f61ed8.PNG)
