package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.SellsummeryEntity;
import com.hua.chick.chicken.service.SellsummeryService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 期间销售汇总
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:11
 */
@RestController
@RequestMapping("chicken/sellsummery")
public class SellsummeryController {
    @Autowired
    private SellsummeryService sellsummeryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sellsummeryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sellNo}")
    public R info(@PathVariable("sellNo") Long sellNo){
		SellsummeryEntity sellsummery = sellsummeryService.getById(sellNo);

        return R.ok().put("sellsummery", sellsummery);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SellsummeryEntity sellsummery){
		sellsummeryService.save(sellsummery);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SellsummeryEntity sellsummery){
		sellsummeryService.updateById(sellsummery);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] sellNos){
		sellsummeryService.removeByIds(Arrays.asList(sellNos));

        return R.ok();
    }

}
