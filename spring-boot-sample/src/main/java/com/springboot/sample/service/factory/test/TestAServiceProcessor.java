package com.springboot.sample.service.factory.test;


import com.springboot.sample.common.enums.SimpleEnum;
import org.springframework.stereotype.Service;

/**
 * @author lingjun.jlj
 * @data 2018/4/28
 * @Description:
 */
@Service
public class TestAServiceProcessor implements TestProcessor {

    @Override
    public int getTag() {
        return SimpleEnum.A.getCode();
    }

    @Override
    public void show() throws Exception {
        System.out.println("A方法");
    }
}
