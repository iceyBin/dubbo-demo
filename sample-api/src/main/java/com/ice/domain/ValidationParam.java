package com.ice.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ValidationParam implements Serializable {

    @NotBlank(message = "'name' must be not blank")
    private String name;

//    @NotNull(groups = ValidationService.Save.class) // 保存时不允许为空，更新时允许为空 ，表示不更新该字段
    @Pattern(regexp = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$")
    private String email;

    @NotNull
    @Size(min = 1, max = 5, message = "the number of 'hobbies' must be between 1 and 5")
    private List<String> hobbies;

    @Min(18) // 最小值
    @Max(100) // 最大值
    @NotNull(message = "age must be not null")
    private Integer age;

    @Past(message = "loginDate must be in the past")
    private Date loginDate;

    @Future(message = "expiryDate must be in the future")
    private Date expiryDate;

    @Valid
    @NotNull(message = "'innerParam' must not be null")
    private InnerValidationParam innerParam;

}
