# elk-demo
Steps to run elk-demo

1. Navigate to kafka-docker-compose folder and execute below command. This folder contains docker-compose file to run Kafka as a docker container.
    docker-compose up --build --force-recreate -d
2. Now run below command to see if the docker container is running. The below command will list the running containers along with their metadata like Container ID, Image etc..
    docker ps
