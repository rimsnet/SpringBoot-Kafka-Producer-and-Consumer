# Apache Kafka

#### https://tecadmin.net/how-to-install-apache-kafka-on-ubuntu-20-04/

#### What is Apache Kafka

* Apache Kafka is an open-source stream-processing software platform which is used to handle the real-time data storage. 
* It works as a broker between two parties, i.e., a sender and a receiver. 
* It can handle about trillions of data events in a day.


#### What is a messaging system

* A messaging system is a simple exchange of messages between two or more persons, devices, etc. 
* A publish-subscribe messaging system allows a sender to send/write the message and a receiver to read that message. 
* **In Apache Kafka, a sender is known as a producer who publishes messages, and a receiver is known as a consumer who consumes that message by subscribing it.**

#### What is Streaming process

* A streaming process is the processing of data in parallelly connected systems. 
* This process allows different applications to limit the parallel execution of the data, where one record executes without waiting for the output of the previous record. 
* Therefore, a distributed streaming platform enables the user to simplify the task of the streaming process and parallel execution. 
* Therefore, a streaming platform in Kafka has the following key capabilities:

  * As soon as the streams of records occur, it processes it.
  * It works similar to an enterprise messaging system where it publishes and subscribes streams of records.
  * It stores the streams of records in a fault-tolerant durable way. (**A fault-tolerant design enables a system to continue its intended operation, possibly at a reduced level, rather than failing completely, when some part of the system fails.**)

![apache-kafka-tutorial-1.png](https://static.javatpoint.com/tutorial/kafka/images/apache-kafka-tutorial-1.png "apache-kafka-tutorial-1.png")


## Terminology

#### Topics
* A stream of messages belonging to a particular category is called a topic. Data is stored in topics.

#### Partition
* Topics may have many partitions, so it can handle an arbitrary amount of data. (**Arbitrary data is any data in any format.**)

#### Partition offset
* Each partitioned message has a unique sequence id called as offset.

#### Replicas of partition
* Replicas are nothing but backups of a partition. Replicas are never read or write data. They are used to prevent data loss.

#### Kafka Cluster
* Kafka’s having more than one broker are called as Kafka cluster. 
* A Kafka cluster can be expanded without downtime. 
* These clusters are used to manage the persistence and replication of message data.

#### Brokers
* Brokers are simple system responsible for maintaining the pub-lished data. 
* Each broker may have zero or more partitions per topic.
* **Kafka cluster typically consists of multiple brokers to maintain load balance.** 
* Kafka brokers are stateless, so they use ZooKeeper for maintaining their cluster state. 
* **One Kafka broker instance can handle hundreds of thousands of reads and writes per second and each bro-ker can handle TB of messages without performance impact.** 

#### ZooKeeper
* ZooKeeper is used for managing and coordinating Kafka broker. 
* ZooKeeper service is mainly used to notify producer and consumer about the presence of any new broker in the Kafka system or failure of the broker in the Kafka system. 
* As per the notification received by the Zookeeper regarding presence or failure of the broker then pro-ducer and consumer takes decision and starts coordinating their task with some other broker.




#### Producers
* Producers are the publisher of messages to one or more Kafka topics. 
* Producers send data to Kafka brokers. Every time a producer pub-lishes a message to a broker, the broker simply appends the message to the last segment file.

#### Consumers

* Consumers read data from brokers. 
* Consumers subscribes to one or more topics and consume published messages by pulling data from the brokers.

```Java

C:\_2.12-2.4.1\bin\windows

zookeeper-server-start.bat C:\_2.12-2.4.1\config\zookeeper.properties

kafka-server-start.bat C:\_2.12-2.4.1\config\server.properties

kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic helloTopic

kafka-console-producer.bat --broker-list localhost:9092 --topic helloTopic

kafka-console-consumer.bat --topic helloTopic --bootstrap-server localhost:9092

```

* To Refer More details : https://dzone.com/articles/magic-of-kafka-with-spring-boot

#### Steps to implements Kafka

* Download Kafka from : https://kafka.apache.org/quickstart

* Before running application follow below steps

  * Go to C:\kafka_2.11-2.0.0\bin\windows  folder using CMD and 
  * You can name every CMD winodw "title name" command
  * Start ZooKeeper : zookeeper-server-start.bat C:\_2.12-2.4.1\config\zookeeper.properties
  * Start Server : kafka-server-start.bat C:\_2.12-2.4.1\config\server.properties
  * Create Topic : kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic helloTopic
  * Start Producer :kafka-console-producer.bat --broker-list localhost:9092 --topic helloTopic
  * Now you can produce all messages either application or producer console
  * Start Consumer : kafka-console-consumer.bat --topic helloTopic --bootstrap-server localhost:9092 to get all produced messages from the topic.
  
##### Step1 Start Zookeeper

  ![ZooKeeper](https://github.com/privatevkakarla/project8-vkakarla-springboot-kafka-producer-consumer-service/blob/master/src/main/resources/Images/ZooKeeper.PNG "ZooKeeper")
  
##### Step2 Start Server

  ![Server](https://github.com/privatevkakarla/project8-vkakarla-springboot-kafka-producer-consumer-service/blob/master/src/main/resources/Images/Server.PNG "Server")  

##### Step3 Create Topic

  ![Topic](https://github.com/privatevkakarla/project8-vkakarla-springboot-kafka-producer-consumer-service/blob/master/src/main/resources/Images/Topic.PNG "Topic") 
  
 ##### Step4 Start Producer

  ![Producer](https://github.com/privatevkakarla/project8-vkakarla-springboot-kafka-producer-consumer-service/blob/master/src/main/resources/Images/Producer.PNG "Producer")
  
 ##### Step5 Start Consumer

  ![Consumer](https://github.com/privatevkakarla/project8-vkakarla-springboot-kafka-producer-consumer-service/blob/master/src/main/resources/Images/Consumer.PNG "Consumer") 
  
  
##### Once you published the messages in topic and consumed from the topic by the consumer

  ![ConsoleOutput](https://github.com/privatevkakarla/project8-vkakarla-springboot-kafka-producer-consumer-service/blob/master/src/main/resources/Images/ConsoleOutput.PNG "ConsoleOutput")   
   
  
