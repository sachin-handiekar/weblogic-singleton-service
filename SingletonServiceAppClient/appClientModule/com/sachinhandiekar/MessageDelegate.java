package com.sachinhandiekar;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.transaction.annotation.Transactional;

import oracle.jms.AQjmsAdtMessage;

import oracle.xdb.XMLType;

public class MessageDelegate implements MessageListener {

    @Transactional
    public void onMessage(Message message) {
        System.out.println("Message Processing Started...");
        try {

            // Converting message into XmlType payload
            XMLType xmlMsg = (XMLType) ((AQjmsAdtMessage) message).getAdtPayload();

            System.out.println("XML ==> " + xmlMsg.getStringVal());

            int MS = 1000;
            Thread.sleep(10 * MS);

        }
        catch (Exception e) {
            // Catch any exception here
            e.printStackTrace();
        }
        System.out.println("Message Processing Ended...");

    }

}
