package com.mmall.Param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Description: TestVo
 * @Author: WuZhenYu
 * @CreateDate: 2019/7/4 22:52
 */
@Getter
@Setter
public class TestVo {

    @NotBlank
    private String msg;

    @NotNull(message = "id不可以为空")
    @Max(value=10, message = "id不能不予10")
    @Min(value = 0, message = "id不能小于0")
    private Integer id;

    @NotEmpty
    private List<String> str;
}
