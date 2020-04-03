#!/bin/bash

pid=($(ps -ef | grep tomcat | grep -v grep | awk '{print $2}'))
length=${#pid[*]}

echo 'Tomcat process ID is ' $pid

if [ $length -gt 0 ]
  then
    for id in $pid
      do
        kill -9 $id
      done

    echo 'kill over ...' $id
fi

sleep 1s

echo 'copy war files ... ...'

cp ./channel-eureka/target/channel-eureka-1.0-SNAPSHOT.war /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-1/ROOT.war
cp ./channel-eureka/target/channel-eureka-1.0-SNAPSHOT.war /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-2/ROOT.war

cp ./test-provider/target/test-provider-1.0-SNAPSHOT.war /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-1/ROOT.war
cp ./test-provider/target/test-provider-1.0-SNAPSHOT.war /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-2/ROOT.war

cp ./test-consumer/target/test-consumer-1.0-SNAPSHOT.war /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-consumer/ROOT.war

echo 'delete deployment folder ... ...'

rm -rf /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-1/ROOT
rm -rf /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-2/ROOT
rm -rf /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-1/ROOT
rm -rf /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-2/ROOT
rm -rf /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-consumer/ROOT

sleep 1s

echo 'unzip ROOT war files ... ...'

mkdir /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-1/ROOT
cd /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-1/ROOT
unzip /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-1/ROOT.war

mkdir /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-2/ROOT
cd /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-2/ROOT
unzip /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-2/ROOT.war

mkdir /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-1/ROOT
cd /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-1/ROOT
unzip /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-1/ROOT.war

mkdir /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-2/ROOT
cd /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-2/ROOT
unzip /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-2/ROOT.war


mkdir /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-consumer/ROOT
cd /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-consumer/ROOT
unzip /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-consumer/ROOT.war

sleep 1s

rm -rf /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-1/ROOT.war
rm -rf /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-2/ROOT.war
rm -rf /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-1/ROOT.war
rm -rf /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-2/ROOT.war
rm -rf /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-consumer/ROOT.war

sleep 1s
cp /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-1/ROOT/WEB-INF/classes/application.master.yml /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-1/ROOT/WEB-INF/classes/application.yml
cp /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-2/ROOT/WEB-INF/classes/application.slaveone.yml /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-eureka-2/ROOT/WEB-INF/classes/application.yml

cp /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-1/ROOT/WEB-INF/classes/application.master.yml /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-1/ROOT/WEB-INF/classes/application.yml
cp /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-2/ROOT/WEB-INF/classes/application.slaveone.yml /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-provider-2/ROOT/WEB-INF/classes/application.yml

cp /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-consumer/ROOT/WEB-INF/classes/application.dist.yml /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/webapps-consumer/ROOT/WEB-INF/classes/application.yml

echo 'Finish copying ... ...'

cd /Users/tigershome/Dev/soft/apache-tomcat-9.0.2/bin
sh startup.sh