# Java Spring & Apache Kafka

Demo application on Java Spring & Apache Kafka. Apache Kafka and Spring Boot will be used to establish communication between them.

Code written while watching Udemy course: [Apache Kafka and Spring Boot](https://www.udemy.com/course/apache-kafka-and-spring-boot-consumer-producer/).

How to consume from an Apache Kafka topic and consume from it using a simple Spring Boot Application. 

This project requires you to have basic experience with Maven, Spring Boot and Apache Kafka.


Apache Kafka



Apache Zookeeper


--------------------------------------------------------------------

### Download Kafka from
	https://kafka.apache.org/

then untar tar.gz and goto foler


### To start Zookeeper service 
	bin/zookeeper-server-start.sh config/zookeeper.properties


### To start Kafka Server 
	bin/kafka-server-start.sh config/server.properties 

Create Java Spring Boot Application with (Spring Web, Spring Kafka and Dev Tools)

### Create a simple REST controller with
 * private KafkaTemplate
 * Post Method to receive Object and return KafkaTemplate.send(producerfactory())
 * A Message Class 
 * Make a Producer Factory to return a Spring Bean of KafkaTemplate, setting necessary configurations of Kafka Topic


    //In Producer Factory add Kafka Topic configurations of Kafka as
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


### To see Kafka Consumer Messages:
	bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic myTopic



Additional Kafka commands

###List all kafka topics with zookeeper
	bin/kafka-topics.sh --list --zookeeper localhost:2181

###List all kafka topics with broker ip:port
	bin/kafka-topics.sh --list --bootstrap-server localhost:9092
