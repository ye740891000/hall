package com.wwx.hall.modules.app.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wwx.hall.common.exception.RRException;
import com.wwx.hall.common.validator.Assert;
import com.wwx.hall.modules.app.dao.UserDao;
import com.wwx.hall.modules.app.entity.UserEntity;
import com.wwx.hall.modules.app.form.LoginForm;
import com.wwx.hall.modules.app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Override
	public UserEntity queryByMobile(String mobile) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public long login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());

		if (user == null){
			throw new RRException("用户不存在");
		}

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			throw new RRException("密码错误",10001);
		}

		return user.getUserId();
	}
}
