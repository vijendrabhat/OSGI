FROM mkroli/karaf:4.2
COPY osgi-service1/target/osgi-service1-1.0-SNAPSHOT.jar /deploy
COPY osgi-service2/target/osgi-service2-1.0-SNAPSHOT.jar /deploy
COPY osgi-spring-boot-demo/target/deploy/osgi-spring-boot-demo-0.0.1-SNAPSHOT.jar /deploy
COPY feature/src/main/resources/features.xml /deploy
EXPOSE 9015
ENTRYPOINT /opt/karaf/bin/client 
ENTRYPOINT /opt/karaf/bin/karaf server