package com.movie.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;
import java.util.Date;
import javax.validation.constraints.NotNull;

public class LoggingProducer {

//    private static final Logger logger = LoggerFactory.getLogger(LoggingProducer.class);
    protected JmsTemplate jmsTemplate;
    private Destination destination;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(@NotNull JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(@NotNull Destination destination) {
        this.destination = destination;
    }

    public void sendMessage(@NotNull String message) {
        final StringBuilder buffer = new StringBuilder();
        buffer.append(new Date()).append(message);

        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage(buffer.toString());
                return message;
            }
        });
    }
}
