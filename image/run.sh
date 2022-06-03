#/bin/bash
docker run -d --name activemq -p 61616:61616 -p 8161:8161 activemq:5.17.1
