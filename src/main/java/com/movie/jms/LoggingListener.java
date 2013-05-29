package com.movie.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class LoggingListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(LoggingListener.class);

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Received message!!!! "+message.toString());
            logger.info("Received message: {}", ((TextMessage) message).getText());
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
        }
    }

}
