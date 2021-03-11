# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

WORKDIR /home/anushaputta

# copy files into image
COPY WordCounter.java /home/anushaputta
ADD /home/data /home/anushaputta/home/data

RUN apk add openjdk8
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV PATH $PATH:$JAVA_HOME/bin

RUN javac WordCounter.java

#RUN mkdir -p /home/output

ENTRYPOINT java WordCounter