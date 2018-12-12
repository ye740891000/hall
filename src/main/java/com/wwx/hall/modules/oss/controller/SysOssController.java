/**
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

package com.wwx.hall.modules.oss.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.wwx.hall.common.constant.UecConstant;
import com.wwx.hall.common.exception.RRException;
import com.wwx.hall.common.utils.PageUtils;
import com.wwx.hall.common.utils.R;
import com.wwx.hall.modules.oss.entity.SysOssEntity;
import com.wwx.hall.modules.oss.service.SysOssService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import static com.wwx.hall.common.constant.UecConstant.FILE_ROOT;

/**
 * 文件上传
 *
 * @author 王伟欣
 * @email 740891000@qq.com
 * @date 2017-03-25 12:13:26
 */
@RestController
@RequestMapping("sys/oss")
public class SysOssController {
	@Autowired
	private SysOssService sysOssService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:oss:all")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = sysOssService.queryPage(params);

		return R.ok().put("page", page);
	}


	/**
	 * 上传文件
	 */
	@PostMapping("/upload")
	@RequiresPermissions("sys:oss:all")
	public R upload(@RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			throw new RRException("上传文件不能为空");
		}
		//上传文件
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String root = FILE_ROOT + DateUtil.today() + "/";
		FileUtil.mkParentDirs(root);
		FileUtil.mkdir(root);
		String localPath = new String(root + RandomStringUtils.randomAlphanumeric(8) + suffix);
		String url = localPath.replace(FILE_ROOT, UecConstant.WEB_LOCAL_HOST);
		File saveFile = new File(localPath);
		file.transferTo(saveFile);
		//保存文件信息
		SysOssEntity ossEntity = new SysOssEntity();
		ossEntity.setLocalPath(localPath);
		ossEntity.setUrl(url);
		ossEntity.setCreateDate(new Date());
		sysOssService.insert(ossEntity);
		return R.ok().put("url", url);
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	@RequiresPermissions("sys:oss:all")
	public R delete(@RequestBody Long[] ids) {
		sysOssService.deleteBatchIds(Arrays.asList(ids));
		return R.ok();
	}

}
