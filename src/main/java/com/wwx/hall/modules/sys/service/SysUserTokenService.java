package com.wwx.hall.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.wwx.hall.common.utils.R;
import com.wwx.hall.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 *
 * @author 王伟欣
 * @email 740891000@qq.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService extends IService<SysUserTokenEntity> {

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
