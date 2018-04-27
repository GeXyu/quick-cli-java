package cn.xiuyu.service.authentication.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.alibaba.dubbo.config.annotation.Service;

import cn.xiuyu.core.dao.authentication.UserRepository;
import cn.xiuyu.core.model.authentication.UserModel;
import cn.xiuyu.service.authentication.api.UserService;

@Service(interfaceClass = UserService.class)
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    @Cacheable(value = "user", key = "#m.id")
    public UserModel save(UserModel m) {
        return userRepository.save(m);
    }

    @Override
    @Cacheable(value = "user", key = "#m.id")
    public UserModel update(UserModel m) {
        return userRepository.save(m);
    }

    @Override
    @Cacheable(value = "user", key = "#id")
    public UserModel show(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    @CacheEvict(value = "user", key = "#id")
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void test() {
        System.out.println("UserService running...");
        rabbitTemplate.convertAndSend("queue", "test-Message");
        System.out.println("send message success");

        UserModel user = new UserModel();
        user.setUsername("123");
        user.setPassword("123");
        user.setEnable(Byte.valueOf("1"));
        save(user);
        System.out.println("save redis and mysql success");
    }

}
