package com.example.usercenter.controller.user;

import com.example.usercenter.domain.entity.user.User;
import com.example.usercenter.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program user-center
 * @description:
 * @author: xiewenhui
 * @create: 2021/03/10 22:17
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class UserController {

    private final UserService userService;
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        log.info("我被请求了～");
       return this.userService.findById(id);
    }

}
