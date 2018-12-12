package com.wwx.hall.modules.business.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wwx.hall.common.utils.PageUtils;
import com.wwx.hall.common.utils.Query;

import com.wwx.hall.modules.business.dao.NameAgeDao;
import com.wwx.hall.modules.business.entity.NameAgeEntity;
import com.wwx.hall.modules.business.service.NameAgeService;


@Service("nameAgeService")
public class NameAgeServiceImpl extends ServiceImpl<NameAgeDao, NameAgeEntity> implements NameAgeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NameAgeEntity> page = this.selectPage(
                new Query<NameAgeEntity>(params).getPage(),
                new EntityWrapper<NameAgeEntity>()
        );

        return new PageUtils(page);
    }

}
