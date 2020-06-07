package com.ice.provider;

import com.ice.api.DemoService;
import com.ice.domain.ValidationParam;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import cn.hutool.core.util.StrUtil;

@Service(version = "1.0", validation = "true")
public class DefaultDemoServiceImpl implements DemoService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        System.out.println("provider sayHello is invoked...");
        return StrUtil.format("{} : Hello, {}", serviceName, name);
    }

    @Override
    public void valid(ValidationParam param) {
        System.out.println("process DefaultDemoService.valid");
    }
}
