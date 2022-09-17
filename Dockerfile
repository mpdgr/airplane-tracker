FROM ubuntu:22.04

RUN apt-get update && apt-get upgrade -y openjdk-17-jre-headless

RUN /bin/bash -c "addgroup --gid 2000 planetracker && \
    adduser --uid 2000 --gid 2000 --disabled-login --gecos 'Airplane Tracker' --home=/home/planetracker planetracker && \
    chmod 700 /home/planetracker" \

USER planetracker

ADD target/airplanetracker.jar /home/planetracker/
ADD data/flights_v2_0305.mv.db /home/planetracker/data/
ADD src/main/resources/log/logback.xml /home/planetracker/src/main/resources/log/

WORKDIR /home/planetracker
EXPOSE 8074
CMD java -jar "/home/planetracker/airplanetracker.jar"