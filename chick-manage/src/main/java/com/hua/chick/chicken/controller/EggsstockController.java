package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.EggsstockEntity;
import com.hua.chick.chicken.service.EggsstockService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 鸡蛋当前库存
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/eggsstock")
public class EggsstockController {
    @Autowired
    private EggsstockService eggsstockService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eggsstockService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{category}")
    public R info(@PathVariable("category") String category){
		EggsstockEntity eggsstock = eggsstockService.getById(category);

        return R.ok().put("eggsstock", eggsstock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EggsstockEntity eggsstock){
		eggsstockService.save(eggsstock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EggsstockEntity eggsstock){
		eggsstockService.updateById(eggsstock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] categorys){
		eggsstockService.removeByIds(Arrays.asList(categorys));

        return R.ok();
    }

}
