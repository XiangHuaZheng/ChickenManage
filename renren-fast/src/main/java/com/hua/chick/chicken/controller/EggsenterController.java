package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.EggsenterEntity;
import com.hua.chick.chicken.service.EggsenterService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 鸡蛋生产入库
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/eggsenter")
public class EggsenterController {
    @Autowired
    private EggsenterService eggsenterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eggsenterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		EggsenterEntity eggsenter = eggsenterService.getById(id);

        return R.ok().put("eggsenter", eggsenter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EggsenterEntity eggsenter){
		eggsenterService.save(eggsenter);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EggsenterEntity eggsenter){
		eggsenterService.updateById(eggsenter);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		eggsenterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
