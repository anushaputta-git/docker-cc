# Alpine Linux with OpenJDK
#FROM openjdk:8-jdk-alpine
FROM openjdk:8-jre-alpine

#WORKDIR /home/anushaputta

# copy files into image
COPY WordCounter.class WordCounter.class

#RUN javac WordCounter.java

ENTRYPOINT java WordCounter

