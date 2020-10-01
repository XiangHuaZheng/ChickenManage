package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.HatchsummeryEntity;
import com.hua.chick.chicken.service.HatchsummeryService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 孵化报表汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/hatchsummery")
public class HatchsummeryController {
    @Autowired
    private HatchsummeryService hatchsummeryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = hatchsummeryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		HatchsummeryEntity hatchsummery = hatchsummeryService.getById(id);

        return R.ok().put("hatchsummery", hatchsummery);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HatchsummeryEntity hatchsummery){
		hatchsummeryService.save(hatchsummery);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody HatchsummeryEntity hatchsummery){
		hatchsummeryService.updateById(hatchsummery);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		hatchsummeryService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
