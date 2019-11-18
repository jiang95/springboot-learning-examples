package com.springboot.sample;

import com.springboot.sample.domain.DO.UserDO;
import com.springboot.sample.service.common.UserService;
import org.apache.catalina.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: Lucifer
 * @date: 2018-12-01 14:30
 * @description:
 */
public class UserTests extends SpringBootSampleTests {

    @Autowired
    private UserService userService;


    @Test
    public void findUserTest() {
        System.out.println(userService.findUser());
    }

    @Test
    public void findByIdTest() {
        System.out.println(userService.findById(1L));
    }

    @Test
    public void updateTest() {
        userService.update();
    }

    @Test
    public void findUserByNameTest() {
        userService.findUserByName("测试1");
    }

    @Test
    public void findUserLikeNameTest() {
        List<UserDO> list = userService.findUserLikeName("测试");
        System.out.println(list);
    }

    @Test
    public void replaceTest(){
        UserDO userDO = new UserDO();
        userDO.setName("蒋灵俊");
        userDO.setAge(24);
        userDO.setPassword("1234561");
        userDO.setCard("330781199509082330");
        userDO.setPhone("17826852173");
        userDO.setProvinceId(2L);
        userDO.setCityId(1L);
        userService.save(userDO);
    }
}
