package com.wwx.hall.modules.app.controller;


import com.wwx.hall.common.constant.UserType;
import com.wwx.hall.common.utils.Constant;
import com.wwx.hall.common.utils.R;
import com.wwx.hall.common.validator.ValidatorUtils;
import com.wwx.hall.modules.app.annotation.Login;
import com.wwx.hall.modules.app.entity.UserEntity;
import com.wwx.hall.modules.app.form.RegisterForm;
import com.wwx.hall.modules.app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 注册
 * @author 王伟欣
 * @email 740891000@qq.com
 * @date 2017-03-26 17:27
 */
@RestController
@RequestMapping("/app")
@Api("APP注册接口")
public class AppRegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    @ApiOperation("注册")
    public R register(@RequestBody RegisterForm form){

        //表单校验
        ValidatorUtils.validateEntity(form);

        UserEntity user = new UserEntity();
        user.setMobile(form.getMobile());
        user.setUsername(form.getUsername());
        user.setUsername(form.getMobile());
        user.setHallId(form.getHallId());
        user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
        user.setCreateTime(new Date());
        userService.insert(user);

        return R.ok();
    }
    @GetMapping("/userinfo")
    @Login(name = UserType.APP)
    public void userinfo(@RequestAttribute("userId") Long userId){
        return;
    }
}
