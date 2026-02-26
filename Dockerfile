
FROM maven:3.8.4-jdk-8-slim AS build
WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests


FROM tomcat:9.0-jdk8-openjdk-slim


WORKDIR /usr/local/tomcat


RUN rm -rf webapps/*


COPY --from=build /app/target/task-esig.war webapps/ROOT.war

# Porta padrãoo
EXPOSE 8080

CMD ["sh", "-c", "catalina.sh run -DDB_URL_COMPLETA=${DATABASE_URL}"]
