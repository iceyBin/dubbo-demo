package com.ice.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class InnerValidationParam implements Serializable {

    @NotEmpty(message = "'param' must not be empty")
    private String param;

}
