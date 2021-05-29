FROM openjdk:11

ARG PROFILE
ARG ADITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADITIONAL_OPTS=${ADITIONAL_OPTS}

WORKDIR /opt/spring_boot
 
COPY /target/stock-quote-manager*.jar stock_quote_manager.jar
 
SHELL ["/bin/sh", "-c"]
 
EXPOSE 5885
EXPOSE 8080
 
CMD java ${ADITIONAL_OPTS} -jar stock_quote_manager.jar --spring.profiles.active=${PROFILE}