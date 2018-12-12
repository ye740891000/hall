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

package com.wwx.hall.modules.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wwx.hall.modules.sys.entity.SysDictEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据字典
 *
 * @author 无量天尊
 * @email 740891000@qq.com
 * @date 2018-09-12 16:22:15
 */
@Mapper
public interface SysDictDao extends BaseMapper<SysDictEntity> {
    /**
     * 根据类型，查询选项
     * @param type 类型
     */
    List<SysDictEntity> queryListType(String type);

    /**
     * 根据类型，查询选项
     * @param types 类型
     */
    List<SysDictEntity> queryListTypes(String[] types);

    List<SysDictEntity> queryTypeAndCode(@Param("type")String type, @Param("code")String code);

    List<SysDictEntity> queryType(@Param("type")String type);
}