#!/bin/bash

REPOSITORY=/home/ec2-user/app/step1
PROJECT_NAME=spring-learn

cd $REPOSITORY/springlearn/$PROJECT_NAME/

echo "> Git Pull"
git pull

echo "> 프로젝트 Build 시작"
./gradlew build

echo "> step1 디렉토리로 이동"
cd $REPOSITORY

echo "> Build 파일 복사"
cp $REPOSITORY/springlearn/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/

echo "> 현재 구동중인 애플리케이션 pid 확인"
CURRENT_PID=$(pgrep -f ${PROEJCT_NAME}.*.jar)

echo "현재 구동 중인 애플리케이션pid: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
	echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
else
	echo "> kill -15 $CURRENT_PID"
	kill -15 $CURRENT_PID
	sleep 5
fi

echo "> 새 어플리케이션 배포"
JAR_NAME=$(ls -tr $REPOSITORY/ | grep jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"
nohup java -jar \
	"-Dspring.config.location=classpath:/application.properties,\
	/home/ec2-user/app/application-oauth.properties,\
	/home/ec2-user/app/application-real-db.properties,\
	classpath:/application-real.properties" \
	-Dspring.profiles.active=real \
$REPOSITORY/$JAR_NAME 2>&1 &
