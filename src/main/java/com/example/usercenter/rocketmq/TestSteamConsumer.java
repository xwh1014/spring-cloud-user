package com.example.usercenter.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * @program user-center
 * @description:
 * @author: xiewenhui
 * @create: 2021/03/26 21:51
 */
@Service
@Slf4j
public class TestSteamConsumer {
    @StreamListener(MySink.MY_INPUT)
    public void receive(String messageBody){
        log.info("通过Steam接收的消息体：messageBody={}",messageBody);
    }
}
