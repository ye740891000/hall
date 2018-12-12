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

package com.wwx.hall.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.wwx.hall.common.utils.PageUtils;
import com.wwx.hall.modules.sys.entity.SysDictEntity;

import java.util.List;
import java.util.Map;

/**
 * 数据字典
 *
 * @author 王伟欣
 * @email 740891000@qq.com
 * @date 2017-06-06 8:49
 */
public interface SysDictService extends IService<SysDictEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 根据类型，查询选项
     * @param types 类型
     */
    List<SysDictEntity> queryListTypes(String[] types);

    /**
     * 根据类型，查询选项
     * @param type 类型
     */
    List<SysDictEntity> queryListType(String type);


    List<SysDictEntity> queryTypeAndCode(String type ,String code);
    List<SysDictEntity> queryType(String type);
}

