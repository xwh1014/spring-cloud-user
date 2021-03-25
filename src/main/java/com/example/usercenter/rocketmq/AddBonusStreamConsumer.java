package com.example.usercenter.rocketmq;


import com.example.usercenter.dao.user.UserMapper;
import com.example.usercenter.domain.dto.message.UserAddBonusMsgDTO;
import com.example.usercenter.domain.entity.user.User;
import com.example.usercenter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(consumerGroup = "test-xxx",topic = "1add-bouns")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class AddBonusStreamConsumer implements RocketMQListener<UserAddBonusMsgDTO> {
    private final UserService userService;
    private final UserMapper userMapper;
//    private final BonusEv
    @Override
    public void onMessage(UserAddBonusMsgDTO message) {
        Integer userId = message.getUserId();
        Integer bonus = message.getBonus();
        User user = this.userMapper.selectByPrimaryKey(userId);
        user.setBonus(user.getBonus() + message.getBonus());
        this.userMapper.updateByPrimaryKey(user);
    }
}