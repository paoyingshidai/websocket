package com.michael.stomp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.michael.stomp.bean.ServerMessage;

@Component
public class DataService {
	
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    //客户端只要订阅了/topic/subscribeTest主题，调用这个方法即可
//    @Scheduled(fixedRate = 1000)
    public void templateTest() {
    	System.out.println("发送消息----------------");
        messagingTemplate.convertAndSend("/topic/subscribeTest", new ServerMessage("服务器主动推的数据" + new Date().getSeconds()));
    }
    
    
    @Scheduled(fixedRate = 1000)
    public void sendToUser() {
    	messagingTemplate.convertAndSendToUser("1", "/message", new ServerMessage("私人信息----"));
    }
    
}
