package com.hua.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hua.chick.chicken.entity.EnterEntity;
import com.hua.chick.chicken.service.EnterService;
import com.hua.common.utils.PageUtils;
import com.hua.common.utils.R;



/**
 * 进鸡登记
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 03:15:12
 */
@RestController
@RequestMapping("chicken/enter")
public class EnterController {
    @Autowired
    private EnterService enterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = enterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		EnterEntity enter = enterService.getById(id);

        return R.ok().put("enter", enter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EnterEntity enter){
		enterService.save(enter);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EnterEntity enter){
		enterService.updateById(enter);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		enterService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
