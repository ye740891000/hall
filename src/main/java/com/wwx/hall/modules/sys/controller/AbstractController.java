package com.wwx.hall.modules.sys.controller;

import com.wwx.hall.common.utils.R;
import com.wwx.hall.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller公共组件
 *
 * @author 王伟欣
 * @email 740891000@qq.com
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected SysUserEntity getUser() {
		return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

	protected Long getDeptId() {
		return getUser().getDeptId();
	}
	public R validParam(BindingResult bindingResult){
		List<ObjectError> list = bindingResult.getAllErrors();
		List<String> errors = new ArrayList<>();
		for (ObjectError error : list) {
			errors.add(error.getDefaultMessage());
		}
		return R.error().put("errors",errors);
	}
}
