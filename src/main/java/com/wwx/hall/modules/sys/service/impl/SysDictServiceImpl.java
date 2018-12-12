/**
 *
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wwx.hall.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wwx.hall.common.utils.PageUtils;
import com.wwx.hall.common.utils.Query;
import com.wwx.hall.modules.sys.dao.SysDictDao;
import com.wwx.hall.modules.sys.entity.SysDictEntity;
import com.wwx.hall.modules.sys.service.SysDictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("sysDictService")
public class SysDictServiceImpl extends ServiceImpl<SysDictDao, SysDictEntity> implements SysDictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String name = (String)params.get("name");

        Page<SysDictEntity> page = this.selectPage(
                new Query<SysDictEntity>(params).getPage(),
                new EntityWrapper<SysDictEntity>()
                    .like(StringUtils.isNotBlank(name),"name", name)
        );

        return new PageUtils(page);
    }

    @Override
    public List<SysDictEntity> queryListType(String type) {
        return baseMapper.queryListType(type);
    }

    public List<SysDictEntity> queryListTypes(String[] types) {
        return baseMapper.queryListTypes(types);
    }

    public List<SysDictEntity> queryTypeAndCode(String type ,String code) {
        return baseMapper.queryTypeAndCode(type,code);
    }

    public List<SysDictEntity> queryType(String type) {
        return baseMapper.queryType(type);
    }

}
