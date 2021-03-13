package com.example.usercenter.service.user;

import com.example.usercenter.dao.user.UserMapper;
import com.example.usercenter.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program user-center
 * @description:
 * @author: xiewenhui
 * @create: 2021/03/10 22:09
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserMapper userMapper;
    public User findById(Integer id){
        return this.userMapper.selectByPrimaryKey(id);
    }
}
