FROM maven:3.8.4-jdk-8-slim AS buildn
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package -DskipTests

FROM tomcat:9.0-jdk8-openjdk-slim

# Remove as aplicações padrão do Tomcat para limpar o ambiente
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia o arquivo .war gerado no estágio de build para o Tomcat
# Certifique-se de que o nome do .war no seu pom.xml coincide (ou use *.war)
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

# Comando para iniciar o Tomcat
CMD ["catalina.sh", "run"]