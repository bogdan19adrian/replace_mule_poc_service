FROM openjdk:11-slim-buster

RUN apt-get update && apt-get install -yq \
       dnsutils \
       iputils-ping \
       iputils-tracepath \
       dnsutils \
       coreutils \
       locate \
       findutils \
       net-tools \
       telnet \
       curl \
       libjemalloc2 \
       iproute2 && apt-get clean && rm -rf /var/lib/apt/lists


ENV LD_PRELOAD "/usr/lib/x86_64-linux-gnu/libjemalloc.so.2"

ARG JAR_FILE
ADD ${JAR_FILE} replace_mule_poc_service.jar
CMD ["java", "-jar" ,"/replace_mule_poc_service.jar"]
EXPOSE 9022
