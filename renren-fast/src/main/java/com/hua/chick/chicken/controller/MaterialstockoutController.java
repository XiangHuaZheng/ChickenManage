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

import com.hua.chick.chicken.entity.MaterialstockoutEntity;
import com.hua.chick.chicken.service.MaterialstockoutService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 原料出库汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/materialstockout")
public class MaterialstockoutController {
    @Autowired
    private MaterialstockoutService materialstockoutService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = materialstockoutService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{outDate}")
    public R info(@PathVariable("outDate") Date outDate){
		MaterialstockoutEntity materialstockout = materialstockoutService.getById(outDate);

        return R.ok().put("materialstockout", materialstockout);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MaterialstockoutEntity materialstockout){
		materialstockoutService.save(materialstockout);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MaterialstockoutEntity materialstockout){
		materialstockoutService.updateById(materialstockout);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Date[] outDates){
		materialstockoutService.removeByIds(Arrays.asList(outDates));

        return R.ok();
    }

}
