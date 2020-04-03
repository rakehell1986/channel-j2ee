#!/bin/bash

cp ./channel-eureka/target/channel-eureka-1.0-SNAPSHOT.war /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-1/ROOT.war
cp ./test-provider/target/test-provider-1.0-SNAPSHOT.war /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-1/ROOT.war
cp ./test-consumer/target/test-consumer-1.0-SNAPSHOT.war /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-consumer/ROOT.war




echo 'Finish copying ... ...'