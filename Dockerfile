FROM openjdk:8
# Add java user
RUN adduser --system javarole \
    && mkdir -p /opt/app \
    && chown -R javarole /opt/app
# Change the work directory
WORKDIR /opt/app
ENV SERVER_PORT 8080
ENV SPRING_PROFILES_ACTIVE dev
COPY target/spring-petclinic-2.0.0.BUILD-SNAPSHOT.jar /opt/app
USER javarole
EXPOSE $SERVER_PORT
CMD java -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -Dserver.port=$SERVER_PORT -jar spring-petclinic-2.0.0.BUILD-SNAPSHOT.jar