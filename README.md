# elk-demo

### Steps to run elk-demo
1. Navigate to kafka-docker-compose folder and execute below command. This folder contains docker-compose file to run Kafka as a docker container.<br>
   1. **docker-compose up --build --force-recreate -d**
2. Now run below command to see if the docker container is running. The below command will list the running containers along with their metadata like Container ID, Image etc..<br>
   1. **docker ps**
3. Now create a kafka topic by running below commands. The alpha-data-service will send logs to this kafka topic.<br>
   1. **docker exec -it kafka bash**(with this command we can go to the bash console of kafka container)<br>
   2. **kafka-topics --bootstrap-server localhost:9092 --create --topic <topic_name> --partitions 1 --replication-factor 1**<br>
      &nbsp;&nbsp;(execute this command inside the bash console, also replace <topic_name> with the desired topic name)<br>
   3. **kafka-topics --bootstrap-server localhost:9092 --list**(this command lists all the avaialble topics in kafka cluster. Verify if the above created topic is listed)<br>
5. We can verify the kafka container logs by running the below command.<br>
   1. **docker-compose logs kafka**
6. Now navigate to alpha-data-service folder and provide the kafka topic name created in previous steps in src/main/resources/application.properties file as below.<br>
   1. **kafka.topic=<topic_name>**
7. Next need to build docker image for the alpha-data-service. Run below command to build docker image inside the alpha-data-service folder.
   1. **docker build -t alpha-data-service .**
8. Now navigate to docker-compose folder and provide the kafka topic name created in previous steps in logstash.conf file. Replace the kafka topic name in below two places.<br>
   <img src="https://github.com/user-attachments/assets/8e85315d-0260-4e0a-aec5-1aff07bdfb78" alt="Description" width="400" height="300"><br>
9. Now run below command in the same folder. This docker compose file will run kibana, elastic search, logstash and alpha-data-service containers.
   1. **docker-compose up --build --force-recreate -d**
10. Now run below command to check the logs of alpha-data-service, if it is up and running.
   1. **docker-compose logs alpha-data-service**
11. Now give a hit to **http://localhost:8080/api/greet** url in the browser.<br>
12. Then we should see the logs in the kibana. For this browse to http://localhost:5601 url. Click on Discover tab as below.<br>
   <img src="https://github.com/user-attachments/assets/0bfaad94-6ff8-4c8d-bf50-2be3577bf62f" alt="Description" width="500" height="350"><br>
13. Now click on 'create data view' button.<br>
   <img src="https://github.com/user-attachments/assets/b8de4ec8-d446-4af4-ae9c-db87130158e0" alt="Description" width="500" height="350"><br>
14. Now fill below values to create the data view. Under Index pattern, give the index pattern mentioned in logstash.conf file and click on 'Save data view to kibana' button.<br>
   <img src="https://github.com/user-attachments/assets/db18010b-4e18-4206-978c-b8ed5520fcfb" alt="Description" width="500" height="350"><br>
15. Now logs should be visible as below.<br>
   <img src="https://github.com/user-attachments/assets/33b70678-afea-47d8-95a2-70b9f2f75801" alt="Description" width="600" height="450"><br>



