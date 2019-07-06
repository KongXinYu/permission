package com.mmall.controller;

import com.mmall.Param.TestVo;
import com.mmall.common.ApplicationContextHelper;
import com.mmall.common.JsonData;
import com.mmall.dao.SysAclModuleMapper;
import com.mmall.exception.PermissonException;
import com.mmall.model.SysAclModule;
import com.mmall.uitl.BeanValidator;
import com.mmall.uitl.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description: TestController
 * @Author: WuZhenYu
 * @CreateDate: 2019/6/30 16:23
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public JsonData hello() {
        log.info("hello");
        throw new PermissonException("test exception");
//      return JsonData.success("hello success!");
    }

    @RequestMapping("/validate")
    @ResponseBody
    public JsonData validate(TestVo vo) {
        log.info("validate");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));
        BeanValidator.check(vo);
        return JsonData.success("validate success!");
    }
}
