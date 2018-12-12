package com.wwx.hall.common.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author 无量天尊
 * @version 0.1v
 * @create 2018-04-09 16:28
 * @see
 **/
public class EntityMetaObjectHandler extends MetaObjectHandler {

	protected final static Logger logger = LoggerFactory.getLogger(EntityMetaObjectHandler.class);

	@Override
	public void insertFill(MetaObject metaObject) {
		Object operateTime = getFieldValByName("operateTime", metaObject);
		if (operateTime == null) {
			setFieldValByName("operateTime", new Date(), metaObject);
		}
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		Object operateTime = getFieldValByName("operateTime", metaObject);
		if (operateTime == null) {
			setFieldValByName("operateTime", new Date(), metaObject);
		}
	}
}
