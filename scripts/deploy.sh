REPOSITORY=/home/ec2-user/app
PROJECT_NAME=spiringboot-intro

echo "COPY JAR"
cp $REPOSITORY/deploy/*.jar $REPOSITORY/

echo "CHECK CURRENT PROCESS"
CURRENT_PID=$(pgrep - fl springboot-intro | grep jar | awk '{print $1}')

echo "CURRENT PID: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
  echo "CURRENT PROCESS IS NOT EXIST"
else
  echo "KILL -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "DEPLOYMENT NEW APPLICATION"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)
chmod +x $JAR_NAME

nohup java -jar \
-Dspring.config.location=classpath:/application.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
-Dspring.profiles.active=real \
$JAR_NAME > $REPOSITORY/nohup.out 2>&1 &