package com.yazykov.projectf.controllers;

import com.yazykov.projectf.models.storage.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableRabbit
public class RabbitMqListener {

//    @Autowired
//    private MessageRepository messageRepository;

    // just write into db all messages(couldn't think about it in the beginning, try next time)
    @RabbitListener(queues = "processingQueue")
    public void listenQueues(String message){
        Message mes = new Message();
        mes.setMessageTime(LocalDateTime.now());
        mes.setMessage(message);
//        messageRepository.save(mes);
    }

}
