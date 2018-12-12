package com.wwx.hall.modules.app.controller;


import com.wwx.hall.common.utils.R;
import com.wwx.hall.common.validator.ValidatorUtils;
import com.wwx.hall.modules.app.form.LoginForm;
import com.wwx.hall.modules.app.service.UserService;
import com.wwx.hall.modules.app.utils.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * APP登录授权
 *
 * @author 王伟欣
 * @email 740891000@qq.com
 * @date 2017-03-23 15:31
 */
@RestController

@RequestMapping("/app")
@Api("APP登录接口")
public class AppLoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登录
     */
    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody LoginForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        //用户登录
        long userId = userService.login(form);

        //生成token
        String token = jwtUtils.generateToken(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        return R.ok(map);
    }

}
