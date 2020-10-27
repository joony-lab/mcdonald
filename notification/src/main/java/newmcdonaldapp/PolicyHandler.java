package newmcdonaldapp;

import newmcdonaldapp.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrderCanceled_SendNotification(@Payload OrderCanceled orderCanceled){

        if(orderCanceled.isMe()){
            System.out.println("##### listener SendNotification : " + orderCanceled.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverOrdered_SendNotification(@Payload Ordered ordered){

        if(ordered.isMe()){
            System.out.println("##### listener SendNotification : " + ordered.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCookStarted_SendNotification(@Payload CookStarted cookStarted){

        if(cookStarted.isMe()){
            System.out.println("##### listener SendNotification : " + cookStarted.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryStart_SendNotification(@Payload DeliveryStart deliveryStart){

        if(deliveryStart.isMe()){
            System.out.println("##### listener SendNotification : " + deliveryStart.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPayApprove_SendNotification(@Payload PayApprove payApprove){

        if(payApprove.isMe()){
            System.out.println("##### listener SendNotification : " + payApprove.toJson());
        }
    }

}
