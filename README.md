# elk-demo

###Steps to run elk-demo
1. Navigate to kafka-docker-compose folder and execute below command. This folder contains docker-compose file to run Kafka as a docker container.
    **docker-compose up --build --force-recreate -d**
2. Now run below command to see if the docker container is running. The below command will list the running containers along with their metadata like Container ID, Image etc..
    **docker ps**
3. Now create a kafka topic by running below commands. The alpha-data-service will send logs to this kafka topic.
    **docker exec -it kafka bash**(with this command we can go to the bash console of kafka container)
    **kafka-topics --bootstrap-server localhost:9092 --create --topic <topic_name> --partitions 1 --replication-factor 1** (execute this command inside the bash console, also replace <topic_name> with             the desired topic name)
    **kafka-topics --bootstrap-server localhost:9092 --list**(this command lists all the avaialble topics in kafka cluster. Verify if the above created topic is listed)
4. We can verify the kafka container logs by running the below command.
    **docker-compose logs kafka**
5. Now navigate to alpha-data-service folder and provide the kafka topic name created in previous steps in application.properties file as below.
    **kafka.topic=<topic_name>**
