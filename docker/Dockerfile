FROM openjdk:8-jre
ADD saas-service-discovery-1.0.0.war saas-service-discovery-1.0.0.war
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar saas-service-discovery-1.0.0.war