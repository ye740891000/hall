package com.wwx.hall.modules.business.controller;

import java.util.Arrays;
import java.util.Map;

import com.wwx.hall.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wwx.hall.modules.business.entity.NameAgeEntity;
import com.wwx.hall.modules.business.service.NameAgeService;
import com.wwx.hall.common.utils.PageUtils;
import com.wwx.hall.common.utils.R;



/**
 * 年龄表
 *
 * @author 王伟鑫
 * @email w17731138318@126.com
 * @date 2018-12-11 14:27:40
 */
@RestController
@RequestMapping("sys/nameage")
public class NameAgeController  extends AbstractController {
    @Autowired
    private NameAgeService nameAgeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:nameage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = nameAgeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:nameage:info")
    public R info(@PathVariable("id") Integer id){
			NameAgeEntity nameAge = nameAgeService.selectById(id);

        return R.ok().put("nameAge", nameAge);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:nameage:save")
    public R save(@RequestBody NameAgeEntity nameAge){
			nameAgeService.insert(nameAge);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:nameage:update")
    public R update(@RequestBody NameAgeEntity nameAge){
			nameAgeService.updateById(nameAge);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:nameage:delete")
    public R delete(@RequestBody Integer[] ids){
			nameAgeService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
