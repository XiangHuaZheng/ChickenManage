package io.renren.chick.chicken.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.chick.chicken.entity.EggsoutEntity;
import io.renren.chick.chicken.service.EggsoutService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 鸡蛋销售出库
 *
 * @author zhengXiangHua
 * @email 912358463@qq.com
 * @date 2020-10-01 15:30:44
 */
@RestController
@RequestMapping("chicken/eggsout")
public class EggsoutController {
    @Autowired
    private EggsoutService eggsoutService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = eggsoutService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		EggsoutEntity eggsout = eggsoutService.getById(id);

        return R.ok().put("eggsout", eggsout);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EggsoutEntity eggsout){
		eggsoutService.save(eggsout);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EggsoutEntity eggsout){
		eggsoutService.updateById(eggsout);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		eggsoutService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
