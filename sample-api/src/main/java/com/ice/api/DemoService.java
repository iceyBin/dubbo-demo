package com.ice.api;

import com.ice.domain.ValidationParam;

import javax.validation.constraints.NotNull;

public interface DemoService {

    String sayHello(String name);

    void valid(@NotNull(message = "'param' must not be null") ValidationParam param);

}
