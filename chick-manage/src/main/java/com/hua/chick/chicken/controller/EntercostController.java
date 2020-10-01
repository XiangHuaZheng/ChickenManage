package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.EntercostEntity;
import com.hua.chick.chicken.service.EntercostService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 进鸡成本统计
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:12
 */
@RestController
@RequestMapping("chicken/entercost")
public class EntercostController {
    @Autowired
    private EntercostService entercostService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = entercostService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{enterDate}")
    public R info(@PathVariable("enterDate") Date enterDate){
		EntercostEntity entercost = entercostService.getById(enterDate);

        return R.ok().put("entercost", entercost);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EntercostEntity entercost){
		entercostService.save(entercost);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EntercostEntity entercost){
		entercostService.updateById(entercost);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Date[] enterDates){
		entercostService.removeByIds(Arrays.asList(enterDates));

        return R.ok();
    }

}
