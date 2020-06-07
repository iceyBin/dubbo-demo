package com.ice;

import com.ice.api.DemoService;
import com.ice.comsumer.ConsumerSampleBootstrap;
import com.ice.domain.InnerValidationParam;
import com.ice.domain.ValidationParam;
import org.apache.dubbo.rpc.RpcException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = {ConsumerSampleBootstrap.class})
@RunWith(SpringRunner.class)
public class TestService {

    @Resource
    private DemoService demoService;

    @Test
    public void validTest() {
        try {
            ValidationParam validationParam = new ValidationParam();
            validationParam.setAge(20);
            validationParam.setEmail("111@qq.com");
            validationParam.setExpiryDate(new Date(new Date().getTime() + TimeUnit.MINUTES.toMillis(1)));
            validationParam.setHobbies(Arrays.asList("运动", "打球"));
            validationParam.setLoginDate(new Date(new Date().getTime() - TimeUnit.MINUTES.toMillis(1)));
            validationParam.setName("summer");
            validationParam.setInnerParam(new InnerValidationParam().setParam("123"));
            demoService.valid(validationParam);

            System.out.println("valid success");
        } catch (ValidationException e) {
            e.printStackTrace();
//            // 里面嵌了一个ConstraintViolationException
//            ConstraintViolationException ve = (ConstraintViolationException) e.getCause();
//            // 可以拿到一个验证错误详细信息的集合
//            Set<ConstraintViolation<?>> violations = ve.getConstraintViolations();
//            System.out.println(violations);
        }
    }
}
