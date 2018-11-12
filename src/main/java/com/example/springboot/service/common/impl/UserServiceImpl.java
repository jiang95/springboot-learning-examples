package com.example.springboot.service.common.impl;

import com.example.springboot.domain.DO.UserDO;
import com.example.springboot.persist.UserMapper;
import com.example.springboot.service.common.UserService;
import com.example.springboot.utils.thread.task.TaskFunction;
import com.example.springboot.utils.thread.task.TaskRequest;
import com.example.springboot.utils.thread.threadpool.FastThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucifer
 * @data 2018/4/2
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private FastThreadPool fastThreadPool;

    /**
     * 线程使用例子
     */
    @Override
    public List<UserDO> findUser() {
        List<TaskFunction> taskFunctions = new ArrayList<>();
        taskFunctions.add(() -> userMapper.selectUser());
        List result = fastThreadPool.execute(new TaskRequest(taskFunctions, false));
        return (List<UserDO>) result.get(0);

    }

    @Override
    public void addUser(UserDO userDO) {
        userMapper.addUser(userDO);
    }

    @Override
    public void update(UserDO userDO) {
        userMapper.update(userDO);
    }
}
