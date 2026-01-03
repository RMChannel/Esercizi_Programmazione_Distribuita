package moto;

import jakarta.ejb.MessageDriven;
import jakarta.jms.*;

/**
 *
 * @author Roberto
 */

@MessageDriven(mappedName="jms/MotoTopic")
public class MotoMDB implements MessageListener {
    
    @Override
    public void onMessage(Message msg) {
        System.out.println("Nuovo messaggio");
        try {
            MotoDTO moto;
            moto=msg.getBody(MotoDTO.class);
            System.out.println(moto);
        } catch (JMSException ex) {
            System.err.println("Error in onMessage(): getBody()");
        }

    }

}

