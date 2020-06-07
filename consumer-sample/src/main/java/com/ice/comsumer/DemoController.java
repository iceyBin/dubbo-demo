package com.ice.comsumer;

import com.ice.api.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.hutool.core.util.StrUtil;

@RestController
@Component
public class DemoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Reference(version = "1.0", check = false)
    private DemoService demoService;

    @GetMapping("/demo/get_user")
    public String getUser() {
        String result = demoService.sayHello("DemoController#getUser");
        logger.info(result);
        return "success";
    }
}
