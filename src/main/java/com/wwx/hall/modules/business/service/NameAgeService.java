package com.wwx.hall.modules.business.service;

import com.baomidou.mybatisplus.service.IService;
import com.wwx.hall.common.utils.PageUtils;
import com.wwx.hall.modules.business.entity.NameAgeEntity;

import java.util.Map;

/**
 * 年龄表
 *
 * @author 王伟鑫
 * @email w17731138318@126.com
 * @date 2018-12-11 14:27:40
 */
public interface NameAgeService extends IService<NameAgeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

