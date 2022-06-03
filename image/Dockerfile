FROM amazoncorretto:17.0.3

ARG URL="https://www.apache.org/dyn/closer.cgi?filename=/activemq/5.17.1/apache-activemq-5.17.1-bin.tar.gz&action=download"
ARG CHECKSUM="cd30ace8dc4fd0fd0c960a0a1442e4f34733defb98fdaff06278a8b392696509fe57601f3e11fe6698f417e223dc43286bf4e86a4999a9848f3cc8dd68f4968f"

ENV PATH=$PATH:/opt/activemq/bin

RUN set -ex && \
    cd /opt && \
    curl -L -o activemq.tgz "${URL}" && \
    echo "${CHECKSUM} activemq.tgz" | sha512sum -c && \
    yum install -y tar gzip && \
    tar xzf activemq.tgz && \
    rm -f activemq.tgz && \
    mv apache-activemq-* activemq && \
    yum erase tar gzip -y && \
    yum clean all -y && \
    rm -rf /var/cache/yum && \
    sed -r 's/127.0.0.1/0.0.0.0/g' -i /opt/activemq/conf/jetty.xml

ENTRYPOINT [ "/opt/activemq/bin/activemq" ]
CMD [ "console" ]

# CORE,MQTT,AMQP,STOMP,HORNETQ,OPENWIRE
EXPOSE 61616
# Web console
EXPOSE 8161
